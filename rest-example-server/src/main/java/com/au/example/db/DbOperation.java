package com.au.example.db;

import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.au.example.db.model.Data;
import com.au.example.db.model.DataDetial;
import com.au.example.db.model.User;
import com.au.example.db.services.DbServices;

@Path("/dbOperation")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class DbOperation {

	@Inject
	DbServices dbServices;

	@GET
	@Path("test")
	public String test() {
		return "test";
	}

	@GET
	@Path("createData")
	public String createData(@QueryParam("name") String name, @QueryParam("type") String type) {
		//
		Data data = new Data();
		DataDetial dataDetial = new DataDetial();
		dataDetial.setValue(name);
		dataDetial.setType(type);
		HashSet<DataDetial> dataDetials = new HashSet<>();
		dataDetials.add(dataDetial);
		data.setDetialSet(dataDetials);
		data.setType(type);
		data.setValue(name);
		data.setDataDetial(dataDetial);
		dbServices.createData(data);
		return "ok";

	}

	@GET
	@Path("getAllAuditData")
	public List<?> getAllAuditData() {
		// TODO Auto-generated method stub
		return dbServices.getAllAuditData();
	}

	@GET
	@Path("getAuditData")
	public List<Data> getAuditData(@QueryParam("id") Integer id) {
		// TODO Auto-generated method stub
		return dbServices.getAuditData(id);
	}

	@GET
	@Path("getAuditDataUseDataDetialId")
	public List<Data> getAuditDataUseDataDetialId(@QueryParam("dataDetialId") Integer dataDetialId) {
		// TODO Auto-generated method stub
		return dbServices.getAuditDataUseDataDetialId(dataDetialId);
	}

	@GET
	@Path("createUser")
	public Long createUser(@QueryParam("name") String name, @QueryParam("surname") String surname, @QueryParam("password") String password,
			@QueryParam("motherName") String motherName) {
		User user = new User();
		user.setName(name);
		user.setSurname(surname);
		user.setPassword(password);
		user.setMotherName(motherName);
		dbServices.createUser(user);
		return user.getId();

	}
	
	
	@GET
	@Path("updateUser")
	public String updateUser(@QueryParam("id") Long id, @QueryParam("name") String name) {
		
		User u = dbServices.findUser(id);
		if(u != null){
			u.setName(name);
		}		

		return "OK";

	}

}
