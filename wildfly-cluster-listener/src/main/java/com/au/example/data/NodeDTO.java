package com.au.example.data;

import java.net.InetAddress;

/**
 * 
 * @author ayhanu
 *
 */
public class NodeDTO {

	private String name;
	private String hostname;
	private String port;
	private InetAddress inetAddress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public InetAddress getInetAddress() {
		return inetAddress;
	}

	public void setInetAddress(InetAddress inetAddress) {
		this.inetAddress = inetAddress;
	}

}
