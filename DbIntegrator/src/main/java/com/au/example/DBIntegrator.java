package com.au.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "com.au.example")
@EnableWebMvc

/**
 * Created by ayhanu on 2/13/17.
 */
public class DBIntegrator {

    private static final Logger log = LoggerFactory.getLogger(DBIntegrator.class);

    public static void main(String[] args) {
        SpringApplication.run(DBIntegrator.class, args);
    }


}