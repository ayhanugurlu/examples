package com.au.example.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.au.example.db.common.ConnectionProperties;
import com.au.example.db.common.dialect.Dialect;
import com.au.example.db.common.dialect.Driver;
import com.au.example.db.common.dialect.Mode;
import com.au.example.db.entity.Data;
import com.au.example.db.entity.DataDetial;

public class MainClass {

	ConnectionProperties prob;

	public static void main(String[] args) {

		MainClass m = new MainClass();
		m.prob = new ConnectionProperties(Driver.H2, "jdbc:h2:tcp://10.0.1.1/~/DevelopmentEnvironment/h2gis-standalone/data/test", "sa", "",
				Dialect.H2, Mode.UPDATE, null);
		m.saveData();
		while(true){
			try {
				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				String s = bufferRead.readLine();
				if(s.equals("exit")){
					break;
				}
				
				

				System.out.println(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		
	}
	
	
	private void saveData(){
		Data d = new Data();
		d.setType("a");
		d.setValue("12");
		DataDetial dd = new DataDetial();
		dd.setType("111");
		dd.setValue("asdasdsa");
		d.setDataDetial(dd);
		prob.getConnection().persist(d);
	}

}
