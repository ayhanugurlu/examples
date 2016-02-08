package com.au.example.websocket.session;

import java.io.IOException;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/getHttpSessionSocket", configurator = GetHttpSessionConfigurator.class)
public class GetHttpSessionSocket {
	private Session wsSession;
	private HttpSession httpSession;

	@OnOpen
	public void open(Session session, EndpointConfig config) {
		this.wsSession = session;
		this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
	}

	@OnMessage
	public String message(String msg) throws IOException {

		if (msg != null && !msg.equals("quit")) {	
			httpSession.setAttribute(msg, msg);
			return msg;
		} else {

			try {
				wsSession.close(new CloseReason(CloseCodes.NORMAL_CLOSURE, "Socket ended"));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return null;
		}

	}
}