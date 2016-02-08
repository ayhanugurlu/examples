package com.au.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/sessionAddParamServlet")
public class SessionAddParamServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 122771056022529368L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		for (Entry<String, String[]> key : req.getParameterMap().entrySet()) {

			req.getSession().setAttribute(key.getKey(), key.getValue()[0]);
		}
		PrintWriter out = resp.getWriter();
		out.println("<h1>" + " add session" + "</h1>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		for (Entry<String, String[]> key : req.getParameterMap().entrySet()) {

			req.getSession().setAttribute(key.getKey(), key.getValue()[0]);
		}

		Enumeration<String> enumeration = req.getSession().getAttributeNames();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			System.out.println(string);
		}

		PrintWriter out = resp.getWriter();
		out.println("<h1>" + " add session" + "</h1>");

	}
}
