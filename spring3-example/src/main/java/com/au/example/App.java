package com.au.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.au.example.bean.HelloBean;
import com.au.example.bean.OtherBean;
import com.au.example.dto.InputDto;
import com.au.example.dto.OutputDto;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

		HelloBean obj = (HelloBean) context.getBean("helloBean");
		String sayhello = obj.sayHello();
		
		InputDto inputDto = new InputDto();
		inputDto.setIn1("in1");
		inputDto.setIn2("in2");		
		inputDto.setIn3("in3");
		OtherBean other = (OtherBean) context.getBean("otherBean");
		OutputDto out = other.test(inputDto);
		
	}
}
