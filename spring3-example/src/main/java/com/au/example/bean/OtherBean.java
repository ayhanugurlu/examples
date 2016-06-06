package com.au.example.bean;

import com.au.example.dto.InputDto;
import com.au.example.dto.OutputDto;
import com.au.example.interceptor.Log;

@Log
public class OtherBean {
	
	public OutputDto test(InputDto dto) {
		OutputDto out = new OutputDto();
		out.setOut1("1");
		out.setOut2("2");
		out.setOut3("3");
		
		return out;
	}

}
