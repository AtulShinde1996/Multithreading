package ScheduledThreadPool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskReminderSystem {

	
	public void reminder(String taskName,int timeInterval,CountDownLatch latch) {
		try {
			System.out.println(Thread.currentThread().getName()+" | task Name"+"-"+"processing...");
			Thread.sleep(300);
			System.out.println(taskName+" is complited by time time interval-"+timeInterval);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			latch.countDown();
		}
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Map<String,Integer>reminders=new HashMap<>();
		reminders.put("Drink Water", 2);
		reminders.put("Check Email", 4);
		reminders.put("Submit Report", 3);
		reminders.put("Stretch Your Legs", 5);
		reminders.put("Review Meeting Notes", 6);
		reminders.put("Stand Up and Move", 7);
		reminders.put("Call Client", 8);
		reminders.put("Backup Files", 9);
		reminders.put("Plan Tomorrow’s Tasks", 10);
		reminders.put("Take a Deep Breath", 11);
		TaskReminderSystem system=new TaskReminderSystem();
		ScheduledExecutorService service=Executors.newScheduledThreadPool(2);
		CountDownLatch latch=new CountDownLatch(reminders.size());
		AtomicInteger delay=new AtomicInteger();
		reminders.forEach((task,time)->{
			service.schedule(()->system.reminder(task, time, latch), delay.getAndIncrement(), TimeUnit.SECONDS);
		});
		latch.await();
		service.shutdown();
		System.out.println("All Reminder is send....");
	}
}
