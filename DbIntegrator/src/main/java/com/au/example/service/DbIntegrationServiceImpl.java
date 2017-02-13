package com.au.example.service;

import com.au.example.data.ConnectionParam;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ayhanu on 2/13/17.
 */
@Service
public class DbIntegrationServiceImpl implements DbIntegrationService {
    @Override
    public boolean testConnection(String connectionUrl, String username, String password) {
        return false;
    }

    @Override
    public List<String> getTableList(ConnectionParam connectionParam) {
        return null;
    }


}
