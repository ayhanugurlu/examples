package com.au.example.data;

/**
 * Created by ayhanu on 2/13/17.
 */
public class ConnectionParam {

    private String connectionUrl;
    private String username;
    private String password;


    public ConnectionParam(String connectionUrl, String username, String password) {
        this.connectionUrl = connectionUrl;
        this.username = username;
        this.password = password;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
