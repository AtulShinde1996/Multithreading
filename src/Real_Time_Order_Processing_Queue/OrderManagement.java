package Real_Time_Order_Processing_Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManagement {

	
	public static void main(String[] args) throws InterruptedException {
		  BlockingQueue<Order> queue = new LinkedBlockingQueue<>();

	        int totalOrders = 20;

	        CountDownLatch latch = new CountDownLatch(totalOrders);

	        // Start producer thread properly  ✔
	        Thread producer = new Thread(new OrderProducer(queue, totalOrders));
	        producer.start();

	        // Create 3 consumer threads  ✔
	        ExecutorService service = Executors.newFixedThreadPool(3);

	        for (int i = 0; i < 3; i++) {
	            service.submit(new OrderProcessor(queue, latch));
	        }

	        // Wait until all orders are processed  ✔
	        latch.await();

	        service.shutdownNow();
	        System.out.println("All Orders Completed Successfully!");

	}
}
