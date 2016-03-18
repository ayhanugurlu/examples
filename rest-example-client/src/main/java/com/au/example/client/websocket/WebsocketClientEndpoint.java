package com.au.example.client.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.ws.rs.client.Client;

@ClientEndpoint
public class WebsocketClientEndpoint {

	private static CountDownLatch latch;

	private static Logger logger = Logger.getLogger(WebsocketClientEndpoint.class.getName());

	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected ... " + session.getId());
		try {
			session.getBasicRemote().sendText("start");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@OnMessage
	public String onMessage(String message, Session session) {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		try {
			logger.info("Received ...." + message);
			String userInput = bufferRead.readLine();
			return userInput;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@OnClose
	public void onClose(Session session, CloseReason closeReason) {
		logger.info(String.format("Session %s close because of %s", session.getId(), closeReason));
		latch.countDown();
	}

	public static void main(String[] args) {
		latch = new CountDownLatch(1);

		try {
			WebSocketContainer container = ContainerProvider.getWebSocketContainer();
			//String uri = "ws://localhost:8080/rest-example-server/websocketServerEndpoint";
			String uri = "ws://localhost:9080/sgrs_sgi_server/ayss-eok-sgi-socket";
			logger.info("Connecting to " + uri);
			container.connectToServer(WebsocketClientEndpoint.class, URI.create(uri));
			latch.await(100, TimeUnit.SECONDS);
		} catch (DeploymentException | InterruptedException | IOException ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
