package com.au.example.listener;

import java.util.List;

import org.wildfly.clustering.group.Group.Listener;
import org.wildfly.clustering.group.Node;


/**
 * Group listener bir node ayağa kalkarsa yada kapanırsa
 * bu listener tetiklenir..
 * 
 * @author ayhanu
 *
 */
public class WildflyGroupListener implements Listener {

	public void membershipChanged(List<Node> prev, List<Node> curr,
			boolean merge) {

		for (Node node : prev)
			System.out.println("PREVIOUS CUSTER VIEW: " + node.getName() + " "
					+ node.getSocketAddress());
		System.out
				.println("==================================================");

		for (Node node : curr)
			System.out.println("NEW CLUSTER VIEW " + node.getName() + " "
					+ node.getSocketAddress());

		System.out
				.println("==================================================");
		System.out.println("Merged ? " + merge);

	}

}