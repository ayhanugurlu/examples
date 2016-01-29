package com.au.example.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.wildfly.clustering.group.Group;
import org.wildfly.clustering.group.Node;

import com.au.example.data.NodeDTO;
import com.au.example.listener.WildflyGroupListener;
import com.au.example.util.CopyStrategy;


/**
 * 
 * Uygulama kalkarken kalkan singleton ejb
 * 
 * 
 * @author ayhanu
 *
 */
@Startup
@Singleton
public class SingletonEJB {

	@Resource(lookup = "java:jboss/clustering/group/web")
	private Group channelGroup;

	private Group channelGroupLookup;

	/**
	 *ilk çalışan yer listener register oluyor
	 * 
	 */
	@PostConstruct
	public void check() {

		try {
			Context context = new InitialContext();
			channelGroupLookup = (org.wildfly.clustering.group.Group) context.lookup("java:jboss/clustering/group/web");
			channelGroupLookup.addListener(new WildflyGroupListener());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		channelGroup.addListener(new WildflyGroupListener());
	}

	
	/**
	 * Tum node listesini alıp geliyor.
	 * 
	 * @return
	 */
	public List<NodeDTO> getAllNode() {
		List<NodeDTO> dtos = new ArrayList<NodeDTO>();
		List<Node> list = channelGroup.getNodes();
		for (Node node : list) {
			NodeDTO nodeDTO = new NodeDTO();
			CopyStrategy.copy(node, nodeDTO);
			dtos.add(nodeDTO);
		}
		return dtos;
	}

	
	/**
	 * Tum node listesini alıyor.
	 * Eger server cluster çalışmaz ise lookupdan alınıp hata alması engellenebilir..
	 * 
	 * @return
	 */
	public List<NodeDTO> getAllNodeLookup() {
		List<NodeDTO> dtos = new ArrayList<NodeDTO>();
		List<Node> list = channelGroupLookup.getNodes();
		for (Node node : list) {
			NodeDTO nodeDTO = new NodeDTO();
			CopyStrategy.copy(node, nodeDTO);
			dtos.add(nodeDTO);
		}
		return dtos;
	}

}