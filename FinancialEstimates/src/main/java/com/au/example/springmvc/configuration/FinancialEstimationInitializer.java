package com.au.example.springmvc.configuration;

import javax.servlet.Filter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class FinancialEstimationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { FinancialEstimationConfiguration.class };
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/api/*" };
    }
    
    @Override
    protected Filter[] getServletFilters() {
        Filter [] singleton = { new CORSFilter()};
        return singleton;
    }
  
}