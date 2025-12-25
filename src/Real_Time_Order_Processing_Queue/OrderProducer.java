package Real_Time_Order_Processing_Queue;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class OrderProducer implements Runnable {
	private final BlockingQueue queue;
	private final int maxOrder;
	

	public OrderProducer(BlockingQueue queue, int maxOrder) {
		super();
		this.queue = queue;
		this.maxOrder = maxOrder;
		
	}

	@Override
	public void run() {
		try {
			Random random = new Random();
			// Order order=new Order();
			for (int i = 1; i <= maxOrder; i++) {
				int delay = random.nextInt(3) + 1;
				Thread.sleep(delay * 1000);

				Order order = new Order(i, // orderId
						"Customer-" + i, // customerName
						random.nextDouble() * 1000, // amount
						LocalDateTime.now() // timestamp
				);
				queue.put(order);
				System.out.println(Thread.currentThread().getName() + " ➜ New Order Created: " + order);
			}

		} catch (Exception e) {
			System.out.println("Producer error: " + e.getMessage());
		} 

	}

}
