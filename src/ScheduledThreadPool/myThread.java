package ScheduledThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class myThread {

	/*
	 * A ScheduledThreadPool is used when you want to run tasks after a delay or
	 * repeatedly at fixed intervals — just like a timer or scheduler.
	 * 
	 * It’s created using the Executors.newScheduledThreadPool(int nThreads) method.
	 */

	// ------------------------------------------------------------------------------

	/*
	 *  Method                                                          Description 
	 *  schedule(Runnable command, long delay,TimeUnit unit)            Runs a task once after a delay. 
	 *  scheduleAtFixedRate(Runnable command, long initialDelay,        Runs a task repeatedly at a fixed rate (based on start time).
	 * long period, TimeUnit unit) 
	 * scheduleWithFixedDelay(Runnable command, long initialDelay, 
	 * long delay,TimeUnit unit)                                         Runs a task repeatedly with a fixed delay between the end of
	 * 																	one and the start of the next.
	 */
	
	public void notification(String email,String massage) {
		System.out.println(Thread.currentThread().getName()+" 📩 "+email);
		try {
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName()+"process the Email."+"- 📩 -"+email+"->"+massage);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ScheduledExecutorService ex=Executors.newScheduledThreadPool(3);
		
		Map<String, String> emailMessageMap = new HashMap<>();

        emailMessageMap.put("atul@example.com", "Hello Atul, welcome to our platform!");
        emailMessageMap.put("rahul@example.com", "Hi Rahul, your subscription is active.");
        emailMessageMap.put("neha@example.com", "Hello Neha, please verify your email address.");
        emailMessageMap.put("amit@example.com", "Hi Amit, your password was changed successfully.");
        emailMessageMap.put("priya@example.com", "Hello Priya, your payment has been received.");
        emailMessageMap.put("rohan@example.com", "Hi Rohan, your order is out for delivery.");
        emailMessageMap.put("sneha@example.com", "Hello Sneha, welcome back! You have 3 new notifications.");
        emailMessageMap.put("vikas@example.com", "Hi Vikas, your profile update was successful.");
        emailMessageMap.put("anita@example.com", "Hello Anita, don’t miss our new offers this week!");
        emailMessageMap.put("kiran@example.com", "Hi Kiran, your account has been upgraded to Premium.");
		
        myThread customeThread=new myThread();
        
        AtomicInteger delay = new AtomicInteger(1);  //normal veriable not work inside of lambda (dealy++)

        emailMessageMap.forEach((email,massage)->{
 //				normal way 
//        	   ex.submit(()->{
//               	customeThread.notification(email, massage);
//               	
//               });
  //    -------------------------------------------------------------------------------
  //			using scheduler
        	ex.schedule(()-> customeThread.notification(email, massage), delay.getAndIncrement(), TimeUnit.SECONDS);
        
        });
     ex.shutdown();
     ex.awaitTermination(20, TimeUnit.SECONDS);
     System.out.println("✅ All Email are send ..");
		
	}
}
