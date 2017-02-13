package com.au.example.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by ayhanu on 2/13/17.
 */
public class Utility {


    private static String TABLE_NAMES = "SELECT DISTINCT OWNER, OBJECT_NAME   FROM ALL_OBJECTS WHERE OBJECT_TYPE = 'TABLE' AND OWNER = ?";

    public static void main(String[] args) throws SQLException {
        Connection connOracle = null;
        Connection connSybase = null;
        Connection connTarget = null;
        try {
            connOracle = getConnectionOracle();
            connSybase = getConnectionSybase();
            connTarget = getConnectionOracle();
            PreparedStatement stat = connOracle.prepareStatement(TABLE_NAMES);
            stat.setString(1, "GKM");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                try {
                    System.out.println("gkm." + rs.getString("OBJECT_NAME"));

                    //String rowCount = "SELECT COUNT(*)   FROM  DBA." + rs.getString("OBJECT_NAME");
                    //PreparedStatement statRowCount = connSybase.prepareStatement(rowCount);
                    //ResultSet rsCount = statRowCount.executeQuery();


                    copy("DBA." + rs.getString("OBJECT_NAME"), "GKM." + rs.getString("OBJECT_NAME"), connSybase, connTarget);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            connOracle.close();
            connSybase.close();

        }
    }

    public static void main_db_oracle(String[] args) throws SQLException {
        Connection connBase = null;
        Connection connFrom = null;
        Connection connTarget = null;
        try {
            connBase = getConnectionOracle();
            connFrom = getConnectionOracle();
            connTarget = getConnectionOracle();
            PreparedStatement stat = connBase.prepareStatement(TABLE_NAMES);
            stat.setString(1, "SGRS_FAT_SILE");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                try {
                    System.out.println("SGRS_FAT_AYVALIK." + rs.getString("OBJECT_NAME"));

                    String rowCount = "SELECT COUNT(*)   FROM  SGRS_FAT_AYVALIK." + rs.getString("OBJECT_NAME");
                    PreparedStatement statRowCount = connBase.prepareStatement(rowCount);
                    ResultSet rsCount = statRowCount.executeQuery();
                    if (rsCount.next() && rsCount.getInt(1) > 0) {
                        continue;
                    }
                    rsCount.close();
                    statRowCount.close();

                    copy("SGRS_FAT_SILE." + rs.getString("OBJECT_NAME"), "SGRS_FAT_AmYVALIK." + rs.getString("OBJECT_NAME"), connFrom, connTarget);
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }

            }

        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            connBase.close();
            connFrom.close();
            connTarget.close();
        }
    }

    public static void main_oracle(String[] args) throws SQLException {

        Connection connFrom = null;
        Connection connTarget = null;
        try {

            connFrom = getConnectionOracle();
            connTarget = getConnectionOracle();
            only_table_copy("SGRS_HM_ENT4.ASSET_SERVER_INFORMATION", "SGRS_HM_SIM.ASSET_SERVER_INFORMATION", connFrom, connTarget);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

            connFrom.close();
            connTarget.close();
        }
    }

    public static void only_table_copy(String tableFrom, String tableTo, Connection from, Connection to) throws SQLException {
        try (PreparedStatement s1 = from.prepareStatement("select * from " + tableFrom); ResultSet rs = s1.executeQuery()) {
            ResultSetMetaData meta = rs.getMetaData();

            List<String> columns = new ArrayList<>();
            for (int i = 1; i <= meta.getColumnCount(); i++)
                columns.add(meta.getColumnName(i));

            try (PreparedStatement s2 = to.prepareStatement("INSERT INTO " + tableTo + " (" + columns.stream().collect(Collectors.joining(", "))
                    + ") VALUES (" + columns.stream().map(c -> "?").collect(Collectors.joining(", ")) + ")")) {

                while (rs.next()) {
                    for (int i = 1; i <= meta.getColumnCount(); i++) {
                        s2.setObject(i, rs.getObject(i));
                    }

                    try {
                        System.out.println(meta.getColumnName(1));
                        s2.execute();
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void copy(String tableFrom, String tableTo, Connection from, Connection to) throws SQLException {
        try (PreparedStatement s1 = from.prepareStatement("select * from " + tableFrom); ResultSet rs = s1.executeQuery()) {
            ResultSetMetaData meta = rs.getMetaData();

            List<String> columns = new ArrayList<>();
            for (int i = 1; i <= meta.getColumnCount(); i++) {
                columns.add(meta.getColumnName(i));
            }


            try (PreparedStatement s2 = to.prepareStatement("INSERT INTO " + tableTo + " (" + columns.stream().collect(Collectors.joining(", "))
                    + ") VALUES (" + columns.stream().map(c -> "?").collect(Collectors.joining(", ")) + ")")) {

                while (rs.next()) {
                    for (int i = 1; i <= meta.getColumnCount(); i++)
                        s2.setObject(i, rs.getObject(i));

                    s2.addBatch();
                }

                s2.executeBatch();
            }
        } finally {
            to.commit();
        }
    }

    private static Connection getConnectionOracle() throws ClassNotFoundException, SQLException {

        // jdbc:oracle:thin:@10.0.0.243:1521:SGRS
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection connection = null;
        //connection = DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.141:1521:SGRS", "sgrs", "123456");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@10.0.1.8:1521:MIGRATETR8", "gkm", "gkm");
        return connection;

    }


    private static Connection getConnectionSybase() throws ClassNotFoundException, SQLException {

        // jdbc:oracle:thin:@10.0.0.243:1521:SGRS
        Class.forName("com.sybase.jdbc3.jdbc.SybDriver");
        Connection connection = null;
        //connection = DriverManager.getConnection("jdbc:oracle:thin:@10.0.0.141:1521:SGRS", "sgrs", "123456");
        connection = DriverManager.getConnection("jdbc:sybase:Tds:10.0.0.146:49162?ServiceName=gkmtg201604", "dba", "sql");

        return connection;

    }
}




