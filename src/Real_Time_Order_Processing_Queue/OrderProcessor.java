package Real_Time_Order_Processing_Queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;


public class OrderProcessor implements Runnable{
	private final BlockingQueue<Order> queue;
	private final CountDownLatch latch;

	public OrderProcessor(BlockingQueue<Order> queue, CountDownLatch latch) {
		super();
		this.queue = queue;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			while(!Thread.currentThread().isInterrupted()) {
				Order order = queue.take();
				  System.out.println(Thread.currentThread().getName() +
	                        " Processing → " + order.getOrderId());
	                Thread.sleep(500);

			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			latch.countDown();
		}
	}

}
