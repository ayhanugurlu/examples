package com.au.example.service;

import com.au.example.data.ConnectionParam;

import java.util.List;

/**
 * Created by ayhanu on 2/13/17.
 */
public interface DbIntegrationService {

    boolean testConnection(String connectionUrl,String username, String password);

    List<String> getTableList(ConnectionParam connectionParam);

}
