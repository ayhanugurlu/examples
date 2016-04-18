package com.au.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MainClass {

	public static void main(String[] args) {

		createObfProperties(args[0]);

	}

	private static void createObfProperties(String obfFilePath) {
		
		
		BufferedReader reader = null;
		PrintWriter pw = null;
		try {
			
			pw = new PrintWriter(obfFilePath+"tmp");
			
			
			File file = new File(obfFilePath);
			reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {

				if(line.contains("-injars")||line.contains("-libraryjars")){
					String newLine = "";
					String jarFolder = line.substring(line.indexOf(' '),line.lastIndexOf('/')).trim();
					String jarName  = line.substring(line.lastIndexOf('/')+1);
					File jarFile = new File(jarFolder);
					if(jarFile.exists()){
						for(String realjarName :jarFile.list()){						
							if(jarName.contains("-")&&(jarName.substring(0,jarName.lastIndexOf('-')).equals(realjarName.substring(0, realjarName.lastIndexOf('-'))))){
								//System.out.println(realjarName.substring(realjarName.lastIndexOf('-')+1,realjarName.length()-4));
								newLine = jarFolder+"/"+realjarName;
								break;
							}						
						}
						
						if(line.contains("-injars")){
							newLine = "-injars "+newLine;
						}else if(line.contains("-libraryjars")){
							newLine = "-libraryjars "+newLine;
						}
					}else{
						newLine = line;
					}
					
										
					System.out.println(newLine);
					pw.println(newLine);
					
				}else{
					System.out.println(line);
					pw.println(line);
					
				}
				

			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader != null){
				try {
					reader.close();
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}




}
