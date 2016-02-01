package com.au.example.client.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.au.example.inheritance.model.Animal;
import com.au.example.inheritance.model.Zoo;
import com.au.example.inheritance.services.RestInheritance;

public class MainClass {

	private static final String SERVER_URL = "http://localhost:8080/rest-example-server/";

	public static void main(String[] args) {
		restInheritanceClientWadlToJava();
		restInheritanceClientTypedWadlToJava();
		restInheritanceClientApache();

	}

	/**
	 * 
	 */
	private static void restInheritanceClientWadlToJava() {

		RestInheritance restInheritance = Utility.createClient(RestInheritance.class, SERVER_URL);
		restInheritance.getDog();

	}

	/**
	 * 
	 */
	private static void restInheritanceClientTypedWadlToJava() {

		RestInheritance restInheritance = Utility.createClienteTyped(RestInheritance.class, SERVER_URL);
		Animal animal = restInheritance.getAnimal();
		System.out.println(animal);

		//Zoo zoo = restInheritance.getZoo();
		//System.out.println(zoo);
	}

	public static void restInheritanceClientApache() {
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet("http://localhost:8080/rest-example-server/restInheritance/getAnimal");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
