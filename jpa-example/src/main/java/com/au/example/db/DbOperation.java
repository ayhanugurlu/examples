package com.au.example.db;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.au.example.db.common.ConnectionProperties;
import com.au.example.db.common.dialect.Dialect;
import com.au.example.db.common.dialect.Driver;
import com.au.example.db.common.dialect.Mode;
import com.au.example.db.entity.Data;
import com.au.example.db.entity.DataDetial;
import com.au.example.db.entity.DataOtherDetial;

public class DbOperation {
	  Logger logger = LoggerFactory.getLogger(DbOperation.class);
	
	private EntityManager em = null;

	
	public DbOperation(){
		ConnectionProperties conProb = new ConnectionProperties(Driver.H2, "jdbc:h2:tcp://10.0.1.1/~/DevelopmentEnvironment/h2gis-standalone/data/test", "sa", "",
				Dialect.H2, Mode.UPDATE, null);
		
		em =  conProb.getConnection();
	}
	
	public Data createData(){		
		em.getTransaction().begin();
		Data data = new Data();
		data .setType("test");
		data.setValue("test1");
		em.persist(data);
		em.getTransaction().commit();		
		logger.debug("Data entity is created");
		logger.info("Data id is :" +data.getId());
		return data;
		
	}
	
	
	public Data createDataWithDetialAndOtherDetial(){		
		em.getTransaction().begin();
		Data data = new Data();
		data .setType("test");
		data.setValue("test1");
		
		
		DataDetial dataDetial = new DataDetial();
		dataDetial.setType("aaaa");
		dataDetial.setValue("asdasd");
		dataDetial.setData(data);
		
		
		DataOtherDetial dataOtherDetial = new DataOtherDetial();
		dataOtherDetial.setType("aaaa");
		dataOtherDetial.setValue("asdasd");
		dataOtherDetial.setData(data);
		
		
		
		data.setDataDetial(dataDetial);
		data.setDataOtherDetial(dataOtherDetial);
		
				
		em.persist(data);		
		em.getTransaction().commit();		
		logger.info("Data entity is created with together DataDetial and DataOtherDetial");
		logger.info("Data id is :" +data.getId());
		logger.info("Data id is :" +data.getDataDetial().getId());
		logger.info("Data id is :" +data.getDataOtherDetial().getId());
		return data;
		
	}
	
	public void deleteData(int id){
		em.getTransaction().begin();
		Data d = em.find(Data.class, id);		
		em.remove(d);		
		em.getTransaction().commit();
		logger.info("Data entity is deleted.");
		
	}
	
	public void deleteDetialData(int id){
		em.getTransaction().begin();
		DataDetial d = em.find(DataDetial.class, id);		
		em.remove(d);
		em.getTransaction().commit();
		logger.info("Datadetial entity is deleted.");
	}
	
	
	
	public void deleteOtherDetialData(int id){
		em.getTransaction().begin();
		DataOtherDetial d = em.find(DataOtherDetial.class, id);		
		em.remove(d);
		em.getTransaction().commit();
		logger.info("DataOtherdetial entity is deleted.");
	}
	
	

}
