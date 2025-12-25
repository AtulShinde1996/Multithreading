package Multiple_Threads_Depositing_Money;

import java.util.LinkedHashMap;
import java.util.Map;

public class Account {

	  static double amount=0.0;
	  static Object lock=new Object();
	  
	public static double getAmount() {
		return amount;
	}

	

	public static void main(String[] args) {
		 Map<String, Double> userWithMoney = new LinkedHashMap<>();
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
	       userWithMoney.forEach((user,deposite)->{
	    	  
	    	   Thread t=new Thread(()->{
	    		   System.out.println(user+" " +"deposite:-"+deposite);
	    		   synchronized (lock) {
	    			   amount+=deposite;
				}
	    	   });
	    	   System.out.println("deposite:-"+deposite+"Complitity");
	    	   t.start();
	    	   try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       });
	       System.out.println("Final Amount:-"+amount);
	}
}
