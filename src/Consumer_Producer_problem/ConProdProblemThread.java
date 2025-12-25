package Consumer_Producer_problem;

import java.util.ArrayList;
import java.util.List;

public class ConProdProblemThread {

	private final List<Integer> shreadResouce = new ArrayList<>();
	private static final Object lock = new Object();
	private static final int CAPACITY = 10;

	public void producer(int number) throws InterruptedException {
		synchronized (lock) {

			while (shreadResouce.size() == CAPACITY) {
				System.out.println("Producer wating .. Buffer is full..");
				lock.wait();
			}
			shreadResouce.add(number);

			System.out.println("Produced: " + number + " | Current size: " + shreadResouce.size());

			// Notify consumer that new data is available
			lock.notify();
		}
	}

	public void consumer(int number) throws InterruptedException {
		synchronized (lock) {

			while (shreadResouce.isEmpty()) {
				System.out.println("Buffer is Empty .. so consumer wating for new item");
				lock.wait();
			}
			
			Integer value = shreadResouce.remove(0);
            System.out.println("Consumed: " + value + " | Current size: " + shreadResouce.size());
            lock.notify();
		}
	}
	public static void main(String[] args) {
		ConProdProblemThread p=new ConProdProblemThread();
		//producer thread
		Thread produce=new Thread(()->{
			for(int i=0;i<=20;i++) {
				try {
					p.producer(i);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread consumer=new Thread(()->{
			for(int i=0;i<=20;i++) {
				try {
					p.consumer(i);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		produce.start();
		consumer.start();
	}

}
