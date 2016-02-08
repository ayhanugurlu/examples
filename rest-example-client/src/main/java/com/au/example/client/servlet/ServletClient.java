package com.au.example.client.servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.au.example.client.websocket.WebSocketEndpoint;

public class ServletClient {

	private static Logger logger = Logger.getLogger(ServletClient.class.getName());

	private String JSESSIONID = null;

	public ArrayList<String> callServletAndReturnCookie() {
		ArrayList<String> cookie = null;
		try {

			URL url = new URL("http://localhost:8080/rest-example-server/sessionAddParamServlet");
			URLConnection conn = url.openConnection();
			if(JSESSIONID != null){
				conn.setRequestProperty(
					    "Cookie","JSESSIONID=" + JSESSIONID);
			}
			conn.setDoOutput(true);

			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			logger.info("key");
			String key = bufferRead.readLine();			
			logger.info("value");
			String value = bufferRead.readLine();

			OutputStream os = conn.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			writer.write(key + "=" + value);
			writer.flush();
			writer.close();
			os.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String response;
			while ((response = in.readLine()) != null) {
				logger.info(response);
			}
			in.close();

			for (int i = 0;; i++) {
				String headerName = conn.getHeaderFieldKey(i);
				String headerValue = conn.getHeaderField(i);

				if (headerName == null && headerValue == null) {
					break;
				}
				if ("Set-Cookie".equalsIgnoreCase(headerName)) {
					String[] fields = headerValue.split(";\\s*");
					cookie = new ArrayList<>();
					for (int j = 0; j < fields.length; j++) {
						System.out.println(fields[j]);
						if(fields[j].contains("JSESSIONID=")){
							JSESSIONID = fields[j].substring(11);	
						}						
						cookie.add(fields[j]);
					}
				}
			}

		} catch (MalformedURLException ex) {
			// a real program would need to handle this exception
		} catch (IOException ex) {
			// a real program would need to handle this exception
		}
		return cookie;
	}

}
