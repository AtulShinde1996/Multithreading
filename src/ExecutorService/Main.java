package ExecutorService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	static List<String> tasks=Arrays.asList("Download Task", "Upload Task", "Backup Task");
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor=Executors.newFixedThreadPool(3);
		
		
		tasks.forEach(task->{
			executor.submit(()->{
				for(int i=0;i<=5;i++) {
					System.out.println(task+"step:-"+1);
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		});
		executor.awaitTermination(5, TimeUnit.SECONDS);

		System.out.println("All task are complity..");
	}
}
