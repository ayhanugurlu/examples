package com.au.example.db.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.au.example.db.common.dialect.Dialect;
import com.au.example.db.common.dialect.Driver;
import com.au.example.db.common.dialect.Mode;

public class ConnectionProperties{
	
	private Driver driver;
	private String url;
	private String user;
	private String password;
	private Dialect dialect;
	private Mode mode;
	List<Class> classes;
	
	private Map properties;
	
	public ConnectionProperties(Driver driver, String url, String user, String password, Dialect dialect, Mode mode, List<Class> classes) {
		
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
		this.dialect = dialect;
		this.mode = mode;
		this.classes = classes;
		
	}
	
	public EntityManager getConnection(){
		
		this.properties = new HashMap();
		this.properties.put("hibernate.dialect", this.dialect.toString());
		this.properties.put("hibernate.hbm2ddl.auto", this.mode.toString());
		this.properties.put("javax.persistence.jdbc.driver", this.driver.toString());
		this.properties.put("javax.persistence.jdbc.url", this.url);
		this.properties.put("javax.persistence.jdbc.user", this.user);
		this.properties.put("javax.persistence.jdbc.password", this.password);
		//this.properties.put(org.hibernate.jpa.AvailableSettings.LOADED_CLASSES,  classes);
		//this.properties.put("", "");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test", properties);
		EntityManager em = emf.createEntityManager();
		
		return em;
		
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Dialect getDialect() {
		return dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	
	

}