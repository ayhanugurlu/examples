package com.au.example.util;

import org.wildfly.clustering.group.Node;

import com.au.example.data.NodeDTO;


/**
 * Dto kopyalama işleri..
 * 
 * @author ayhanu
 *
 */
public class CopyStrategy {
	
	
	public static void copy(Node node,NodeDTO nodeDTO){
		
		nodeDTO.setHostname(node.getSocketAddress().getHostName());
		nodeDTO.setName(node.getName());
		nodeDTO.setPort(Integer.toString(node.getSocketAddress().getPort()));
		nodeDTO.setInetAddress(node.getSocketAddress().getAddress());
		
	}
	

}
