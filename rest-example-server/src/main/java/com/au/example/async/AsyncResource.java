package com.au.example.async;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.MediaType;

@Path("/asyncResource")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class AsyncResource {

	
	@GET
	@Path("test")
	public String test() {
		return "test";
	}
	
	@GET
	@Path("asyncGet")
	public void asyncGet(final AsyncResponse asyncResponse) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				
				String result = veryExpensiveOperation();
				try {
					System.out.println("bekliyor");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("devam ediyor");
				asyncResponse.resume(result);

			}

			private String veryExpensiveOperation() {
				return "test";
			}
		}).start();
	}

}
