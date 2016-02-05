package com.au.example.async;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.Suspended;
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
	public void asyncGet(@Suspended final AsyncResponse asyncResponse) {

		asyncResponse.setTimeout(1000, TimeUnit.MILLISECONDS);

		// servis tamamlandıgında calısıyor
		asyncResponse.register(new CompletionCallback() {

			@Override
			public void onComplete(Throwable throwable) {
				// TODO Auto-generated method stub
				System.out.println("asenkron servis tamamlandı");

			}
		});

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread baslıyor");
				String result = veryExpensiveOperation();
				System.out.println("servis devem ediyor");
				asyncResponse.resume(result);

			}

			private String veryExpensiveOperation() {
				try {
					System.out.println("bekliyor");
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "test";
			}
		}).start();
		System.out.println("servis bitti..");
	}


}
