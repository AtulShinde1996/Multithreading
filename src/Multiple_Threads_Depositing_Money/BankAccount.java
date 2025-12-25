package Multiple_Threads_Depositing_Money;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankAccount {

	/*
	 * We’ll simulate multiple users depositing money into the same bank account at
	 * the same time using threads. Without synchronization, the balance could
	 * become inconsistent. With synchronization, we ensure thread-safe updates.
	 */
	 private double amount=0.0;
	 private Object lock=new Object();
	
	public  void deposit(double depositMoney,String user) {
		try {
			System.out.println(user+" "+"deposit money"+depositMoney);
			synchronized (lock) {
				amount+=depositMoney;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 System.out.println(" new balance: " + amount);
	}
	
	
	public double getAmount() {
		return amount;
	}


	


	public static void main(String[] args) throws InterruptedException {
		ExecutorService exicutor=Executors.newFixedThreadPool(3);
		Map<String, Double> userWithMoney=new LinkedHashMap<String, Double>();
		userWithMoney.put("user-1", 1000d);
		userWithMoney.put("user-2", 1500d);
		userWithMoney.put("user-3", 1630d);
		userWithMoney.put("user-4", 3500d);
		userWithMoney.put("user-5", 1350d);
		userWithMoney.put("user-6", 6735d);
		userWithMoney.put("user-7", 9073d);
		userWithMoney.put("user-8", 2300d);
		userWithMoney.put("user-9", 1000d);
		userWithMoney.put("user-10", 7800d);
		
		BankAccount account=new BankAccount();
		
		userWithMoney.forEach((k,v)->{
			exicutor.submit(()->{
				account.deposit(v, k);
			});
			
		});
		exicutor.shutdown(); // Stop accepting new tasks
		exicutor.awaitTermination(10, TimeUnit.SECONDS); // Wait for all tasks to finish just like join method
		System.out.println("All user deposit complete. Final Amount: " + account.getAmount());


	}
	
}
