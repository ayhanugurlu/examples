package com.au.example.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.au.example.db.DbOperation;
import com.au.example.db.common.ConnectionProperties;

public class MainClass {

	ConnectionProperties prob;

	public static void main(String[] args) {
		DbOperation dbOperation = new DbOperation();
		System.out.println("1 : Create Dummy Data");
		System.out.println("2 : Create Dummy Data , DataDetial and DataOtherDetial");
		System.out.println("3 : Delete Data with use id.");
		System.out.println("4 : Delete DataDetial with use id");
		System.out.println("5 : Delete DataOtherDetial with use id");
		while (true) {
			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				String s = bufferRead.readLine();
				if (s.equals("exit")) {
					break;
				}

				switch (s) {
				case "1":
					dbOperation.createData();
					break;
				case "2":
					dbOperation.createDataWithDetialAndOtherDetial();
					break;
				case "3":
					System.out.println("Please enter data id :");
					bufferRead = new BufferedReader(new InputStreamReader(System.in));
					s = bufferRead.readLine();
					dbOperation.deleteData(Integer.parseInt(s));
					break;
				case "4":
					System.out.println("Please enter datadetial id :");
					bufferRead = new BufferedReader(new InputStreamReader(System.in));
					s = bufferRead.readLine();
					dbOperation.deleteDetialData(Integer.parseInt(s));
					break;
				case "5":
					System.out.println("Please enter dataotherdetial id :");
					bufferRead = new BufferedReader(new InputStreamReader(System.in));
					s = bufferRead.readLine();
					dbOperation.deleteOtherDetialData(Integer.parseInt(s));
					break;
				

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
