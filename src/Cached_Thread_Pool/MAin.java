package Cached_Thread_Pool;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MAin {

	public static void main(String[] args) {
		  Random random = new Random();
	        int number = 10 + random.nextInt(90);
	        ExecutorService ex=Executors.newCachedThreadPool();
	        
	        try {
				for(int i=0;i<=number;i++) {
					ex.submit(new Client_Requests(i));
				}
				
				ex.shutdown();
				ex.awaitTermination(2, TimeUnit.SECONDS);
				System.out.println("All request :-"+ number);
		        System.out.println("All client requests submitted. Server shutting down soon...");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
