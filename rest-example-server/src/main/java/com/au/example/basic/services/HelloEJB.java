package com.au.example.basic.services;

import javax.ejb.Local;

@Local
public interface HelloEJB {

    String sayHelloEJB(String name);
}