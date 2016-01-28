package com.ayhan.util;

import org.wildfly.clustering.group.Node;

import com.ayhan.data.NodeDTO;

public class CopyStrategy {
	
	
	public static void copy(Node node,NodeDTO nodeDTO){
		
		nodeDTO.setHostname(node.getSocketAddress().getHostName());
		nodeDTO.setName(node.getName());
		nodeDTO.setPort(Integer.toString(node.getSocketAddress().getPort()));
		nodeDTO.setInetAddress(node.getSocketAddress().getAddress());
		
	}
	

}
