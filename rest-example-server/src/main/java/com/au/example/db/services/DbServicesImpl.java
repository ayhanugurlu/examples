package com.au.example.db.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.au.example.db.dao.DataDao;
import com.au.example.db.model.Data;

@Named
public class DbServicesImpl implements DbServices{

	@Inject 
	DataDao dataDao;
	
	@Override
	public void createData(Data data) {
		// TODO Auto-generated method stub
		dataDao.create(data);
		
	}

	@Override
	public Data findById(Integer id) {
		// TODO Auto-generated method stub
		return dataDao.findById(id);
	}



	@Override
	public List<?> getAllAuditData() {
		// TODO Auto-generated method stub
		return dataDao.getAllAuditData();
	}

	@Override
	public List<Data> getAuditData(Integer id) {
		// TODO Auto-generated method stub
		return dataDao.getAuditData(id);
	}

	@Override
	public List<Data> getAuditDataUseDataDetialId(Integer dataDetialId) {
		// TODO Auto-generated method stub
		return dataDao.getAuditDataUseDataDetialId(dataDetialId);
	}



}
