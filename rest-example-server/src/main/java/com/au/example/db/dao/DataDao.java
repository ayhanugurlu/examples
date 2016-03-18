package com.au.example.db.dao;

import java.util.List;

import javax.ejb.Local;

import com.au.example.db.model.Data;

@Local
public interface DataDao {

	void create(Data data);

	Data findById(Integer id);

	List<?> getAllAuditData();
	
	List<Data> getAuditData(Integer id);
	
	List<Data> getAuditDataUseDataDetialId(Integer dataDetialId);

}
