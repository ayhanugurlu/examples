package com.au.example.services;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.au.example.dto.Input;
import com.au.example.dto.Output;

@Stateless
@WebService
public class WsExample {

	@WebMethod
	public Output getPerson(@WebParam(name = "userId") String userId, @WebParam(name = "input") Input input) {
		Output out = new Output();
		out.setOut1("test");
		return out;
	}

}
