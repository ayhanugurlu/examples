package com.ayhan.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.wildfly.clustering.group.Group;
import org.wildfly.clustering.group.Node;

import com.ayhan.data.NodeDTO;
import com.ayhan.listener.WildflyGroupListener;
import com.ayhan.util.CopyStrategy;

@Startup
@Singleton
public class SingletonEJB {

	@Resource(lookup = "java:jboss/clustering/group/web")
	private Group channelGroup;

	@PostConstruct
	public void check() {		
		channelGroup.addListener(new WildflyGroupListener());
	}

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

}