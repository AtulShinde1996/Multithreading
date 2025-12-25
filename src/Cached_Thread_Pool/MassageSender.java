package Cached_Thread_Pool;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MassageSender {
	
	
	public void sendingMechanisum(String massage,int id)  {
		System.out.println(Thread.currentThread().getName()+" | "+"massage-"+massage+" | "+"id:-"+id);
		 try {
			int delay = 500 + (int)(Math.random() * 1500);
			 Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println(Thread.currentThread().getName() + " ✅ Message #" + id + " sent successfully!");

	}

	public static void main(String[] args) {
			ExecutorService ex=Executors.newCachedThreadPool();
			MassageSender sendr=new MassageSender();
		   Map<Integer, String> messageMap = new LinkedHashMap<>();

	        messageMap.put(1, "Hello, User 1!");
	        messageMap.put(2, "Welcome to our service!");
	        messageMap.put(3, "Your OTP is 4587");
	        messageMap.put(4, "Your report is ready for download.");
	        messageMap.put(5, "Thank you for using our app!");
	        
	        try {
				
	        	messageMap.forEach((id,massge)->{
	        		ex.submit(()->{
	        			sendr.sendingMechanisum(massge, id);
	        		});
	        	});
	        	
	        	ex.shutdown();
	        	ex.awaitTermination(5, TimeUnit.SECONDS);
			} catch (Exception e) {
				// TODO: handle exception
			}
	        
	}
}
