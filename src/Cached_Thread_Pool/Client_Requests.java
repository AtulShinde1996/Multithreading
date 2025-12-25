package Cached_Thread_Pool;

public class Client_Requests implements Runnable {

	/*
	 * “Handling Multiple Client Requests”
	 * 
	 * Imagine a web server or API service that receives a burst of short client
	 * requests. We don’t know how many requests will arrive — sometimes 2,
	 * sometimes 20 — so we use a Cached Thread Pool because it can grow and shrink
	 * dynamically.
	 */

	private final int requestId;
	
	
	public Client_Requests(int requestId) {
		super();
		this.requestId = requestId;
	}


	@Override
	public void run() {
	try {
		System.out.println(Thread.currentThread().getName()+"-"+"process the request.."+requestId);
		Thread.sleep(200);
	} catch (Exception e) {
		System.out.println("Error occures in Api request. "+requestId);
	}

	}

}
