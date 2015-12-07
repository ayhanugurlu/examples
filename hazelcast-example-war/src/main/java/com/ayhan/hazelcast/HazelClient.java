package com.ayhan.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class HazelClient {

	private static HazelClient instance = null;

	public static HazelClient getHazelClient() {
		if (instance == null) {
			instance = new HazelClient();
		}
		return instance;

	}

	private HazelcastInstance client;

	private HazelClient() {
		ClientConfig clientConfig = new ClientConfig();
		ClientNetworkConfig clientNetworkConfig = new ClientNetworkConfig();
		clientNetworkConfig.addAddress("192.168.95.1:5701");
		clientConfig.setNetworkConfig(clientNetworkConfig);
		HazelcastInstance client = HazelcastClient
				.newHazelcastClient(clientConfig);
		this.client = client;
		
	}

	public void addValue(String key, String value) {
		IMap<String, String> exampleMap = client.getMap("example");
		exampleMap.put(key, value);
	}

	public String getValue(String key) {
		IMap<String, String> exampleMap = client.getMap("example");
		return exampleMap.get(key);
	}

}
