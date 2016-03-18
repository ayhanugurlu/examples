package com.au.example.client.rs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Response;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.au.example.client.util.Utility;
import com.au.example.exception.RestException;
import com.au.example.inheritance.model.Animal;
import com.au.example.inheritance.model.Dog;
import com.au.example.inheritance.model.Zoo;
import com.au.example.inheritance.services.RestInheritance;

public class RestClient {

	private static Logger logger = Logger.getLogger(RestClient.class.getName());

	private static final String SERVER_URL = "http://localhost:8080/rest-example-server/";

	public static void main(String[] args) {
//		restExceptionClientWadlToJava();
		restAsyncClientTest();
//		restInheritanceClientWadlToJava();
//		restInheritanceClientTypedWadlToJava();
//		restInheritanceClientApache();
//		restAsyncClient();
//		restAsyncClientInvocationCallback();

	}
	
	
	/**
	 * 
	 */
	private static void restExceptionClientWadlToJava() {

		RestException restInheritance = Utility.createClientExceptionFilter(RestException.class, SERVER_URL);
		try {
			restInheritance.testExp();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

	/**
	 * 
	 */
	private static void restInheritanceClientWadlToJava() {

		RestInheritance restInheritance = Utility.createClient(RestInheritance.class, SERVER_URL);
		Dog d = restInheritance.getDog();
		Zoo zoo = restInheritance.getZoo();
		logger.info("Response code " + zoo.toString());

	}

	/**
	 * 
	 */
	private static void restInheritanceClientTypedWadlToJava() {

		RestInheritance restInheritance = Utility.createClienteTyped(RestInheritance.class, SERVER_URL);
		Animal animal = restInheritance.getAnimal();
		logger.info("Response code " + animal.toString());

	}

	public static void restInheritanceClientApache() {
		try {

			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpGet getRequest = new HttpGet(SERVER_URL + "restInheritance/getAnimal");
			getRequest.addHeader("accept", "application/json");

			HttpResponse response = httpClient.execute(getRequest);

			if (response.getStatusLine().getStatusCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			logger.info("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				logger.info(output);
			}

			httpClient.getConnectionManager().shutdown();

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void restAsyncClient() {

		Client client = ClientBuilder.newClient();
		Future<Response> futureResponse = client.target(SERVER_URL + "asyncResource").path("asyncGet").request().async().get();
		try {
			String resp = futureResponse.get().readEntity(String.class);
			logger.info("Response code " + resp);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	public static void restAsyncClientTest() {

		Client client = ClientBuilder.newClient();
		Future<Response> futureResponse = client.target("http://10.0.1.1:9080/sgrs_sgi_server/api/ayss-eok-sgi/").path("dayLightCamera/setZoomAsync/20").request().async().get();
		try {
			String resp = futureResponse.get().readEntity(String.class);
			logger.info("Response code " + resp);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void restAsyncClientInvocationCallback() {

		Client client = ClientBuilder.newClient();

		Future<String> futureResponse = client.target(SERVER_URL + "asyncResource").path("asyncGet").request().async()
				.get(new InvocationCallback<String>() {
					@Override
					public void completed(String response) {
						logger.info("Response code " + response);

					}

					@Override
					public void failed(Throwable throwable) {
						logger.info("Failed");
						throwable.printStackTrace();
					}
				});

		try {
			logger.info(futureResponse.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
