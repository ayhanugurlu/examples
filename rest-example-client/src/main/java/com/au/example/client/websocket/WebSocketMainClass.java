package com.au.example.client.websocket;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class WebSocketMainClass {
	
	private static Logger logger = Logger.getLogger(WebsocketClientEndpoint.class.getName());

	public final static  CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) {
		
		try {
			connectSgi();
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
//		WebSocketEndpoint webSocketEndpoint = new WebSocketEndpoint();
//		
//		logger.info("call servlet and add param session");
//		ServletClient servletClient = new ServletClient();
//		ArrayList<String> cookie  = servletClient.callServletAndReturnCookie();		
//		try {			
//			webSocketEndpoint.connect(cookie);
//			latch.await();
//			servletClient.callServletAndReturnCookie();
//		} catch (DeploymentException | InterruptedException | IOException ex) {
//			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//		}
		
		
		
	}
	
	public static void connectSgi() throws DeploymentException, IOException{		
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		String uri = "ws://localhost:9080/sgrs_sgi_server/ayss-eok-sgi-socket";
		logger.info("Connecting to " + uri);
		Session s = container.connectToServer(WebsocketClientEndpoint.class, URI.create(uri));
		System.out.println("asdasdasdasdasdasdasdasda");
	}

}
