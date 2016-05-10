package com.au.example.db.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.au.example.db.dao.DataDao;
import com.au.example.db.dao.UserDao;
import com.au.example.db.model.Data;
import com.au.example.db.model.User;

@Named
public class DbServicesImpl implements DbServices {

	@Inject
	DataDao dataDao;

	@Inject
	UserDao userDao;

	@Override
	public void createData(Data data) {

		dataDao.create(data);

	}

	@Override
	public Data findById(Integer id) {

		return dataDao.findById(id);
	}

	@Override
	public List<?> getAllAuditData() {

		return dataDao.getAllAuditData();
	}

	@Override
	public List<Data> getAuditData(Integer id) {

		return dataDao.getAuditData(id);
	}

	@Override
	public List<Data> getAuditDataUseDataDetialId(Integer dataDetialId) {

		return dataDao.getAuditDataUseDataDetialId(dataDetialId);
	}

	@Override
	public void createUser(User u) {

		userDao.create(u);
	}

	@Override
	public void updateUser(User u) {

	}

	@Override
	public User findUser(Long id) {

		return userDao.findById(id);
	}

}
