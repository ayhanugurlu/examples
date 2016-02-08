package com.au.example.websocket.session;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfigurator extends ServerEndpointConfig.Configurator {
	@Override
	public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest request, HandshakeResponse response) {
		HttpSession httpSession = (HttpSession) request.getHttpSession();
		writeAllAttributeNameSession(httpSession);
		config.getUserProperties().put(HttpSession.class.getName(), httpSession);
	}

	private void writeAllAttributeNameSession(HttpSession session) {
		Enumeration<String> attirubeteNameEnumeration = session.getAttributeNames();
		while (attirubeteNameEnumeration.hasMoreElements()) {
			String string = (String) attirubeteNameEnumeration.nextElement();
			System.out.println(string);

		}

	}
}
