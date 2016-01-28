package com.ayhan.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ayhan.data.NodeDTO;
import com.ayhan.ejb.SingletonEJB;

@Path("/clusterStateService")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ClusterStateService {

	@EJB
	SingletonEJB singletonEJB;

	/**
	 * 
	 * 
	 * @return
	 */
	@GET
	@Path("getState")
	public String getState() {
		StringBuffer buff = new StringBuffer();
		List<NodeDTO> dtos = singletonEJB.getAllNode();
		for (NodeDTO dto : dtos) {
			buff.append(dto.getName());
			buff.append(" ");
			buff.append(dto.getHostname());
			buff.append(":");
			buff.append(dto.getPort());
			buff.append("<br>");
		}
		return buff.toString();

	}
	
	
	@GET
	@Path("test")
	public String test() {
		return "test";

	}

}
