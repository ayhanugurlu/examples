package com.au.example.client.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.websocket.ClientEndpointConfig;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 * 
 * @author ayhanu
 *
 */
public class WebSocketEndpoint extends Endpoint {
	
	private static Logger logger = Logger.getLogger(WebSocketEndpoint.class.getName());

	private Session session;


	public void connect(ArrayList<String> cookie) throws DeploymentException, IOException{		
		ClientEndpointConfig clientEndpointConfig = getClientEndPointConfig(cookie);
		WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		String uri = "ws://localhost:8080/rest-example-server/getHttpSessionSocket";
		logger.info("Connecting to " + uri);
		session = container.connectToServer(WebSocketEndpoint.class, clientEndpointConfig, URI.create(uri));
	}
	
	public ClientEndpointConfig getClientEndPointConfig(final ArrayList<String> cookie) {
		return ClientEndpointConfig.Builder.create().configurator(new ClientEndpointConfig.Configurator() {
			@Override
			public void beforeRequest(Map<String, List<String>> headers) {
				headers.put("Cookie", cookie);
			}
		}).build();
	}

	@Override
	public void onOpen(final Session session, EndpointConfig config) {
		this.session = session;
		session.addMessageHandler(new MessageHandler.Whole<String>() {
			@Override
			public void onMessage(String message) {

				BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
				try {
					logger.info("Received ...." + message);
					String userInput = bufferRead.readLine();
					session.getBasicRemote().sendText(userInput);

				} catch (IOException e) {
					throw new RuntimeException(e);
				}

			}

		});

		logger.info("Connected ... " + session.getId());

		

		try {
			session.getBasicRemote().sendText("start");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onClose(Session sess, CloseReason closeReason) {
		this.session = null;		
		WebSocketMainClass.latch.countDown();	
		
	}

}
