package Restaurant_Order_System;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<Order>orders=Arrays.asList(new Order(101, "Atul", "Pizza", 4, 90),
				new Order(2, "Sneha", "Pizza", 1, 250.0),
                new Order(3, "Ravi", "Coffee", 3, 80.0),
                new Order(4, "Neha", "Sandwich", 2, 100.0),
                new Order(5, "Raj", "Pasta", 1, 180.0));
		
		
		ExecutorService ex=Executors.newFixedThreadPool(3);
		orders.forEach(order->{
			ex.submit(new OrderProcess(order));
		});
		
		ex.shutdown();
		ex.awaitTermination(5, TimeUnit.SECONDS);
	}
}
