package ScheduledThreadPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class UsingCountDownLatch {

	public void reminder(String user,CountDownLatch latch) {
		System.out.println(Thread.currentThread().getName()+" | user;-"+user+" | ");
		try {
			Thread.sleep(300);
            System.out.println("👉 Reminder sent to " + user + ": Don't forget your weekly report!\n");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			latch.countDown();
		}
	}
	
	public static void main(String[] args) {
		ScheduledExecutorService service=Executors.newScheduledThreadPool(2);
	
		UsingCountDownLatch task = new UsingCountDownLatch();
		 
		  List<String> users = Arrays.asList(
	                "atul@example.com", "rahul@example.com", "neha@example.com",
	                "amit@example.com", "priya@example.com"
	        );
		  
		  CountDownLatch latch=new CountDownLatch(users.size());
		  System.out.println("\n📢 Starting new reminder cycle...\n");
		  users.forEach(user->{
			  service.schedule  (()->task.reminder(user, latch), 2, TimeUnit.SECONDS);
		  });
		  
		  try {
			latch.await();
		    System.out.println("✅ All reminders sent successfully!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  service.shutdown();
	}
	
}
