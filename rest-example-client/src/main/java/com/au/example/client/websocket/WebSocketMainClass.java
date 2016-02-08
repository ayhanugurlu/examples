package com.au.example.client.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.DeploymentException;
import javax.ws.rs.client.Client;

import com.au.example.client.servlet.ServletClient;

public class WebSocketMainClass {
	
	private static Logger logger = Logger.getLogger(WebsocketClientEndpoint.class.getName());

	public final static  CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) {
		
		WebSocketEndpoint webSocketEndpoint = new WebSocketEndpoint();
		
		logger.info("call servlet and add param session");
		ServletClient servletClient = new ServletClient();
		ArrayList<String> cookie  = servletClient.callServletAndReturnCookie();		
		try {			
			webSocketEndpoint.connect(cookie);
			latch.await();
			servletClient.callServletAndReturnCookie();
		} catch (DeploymentException | InterruptedException | IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
