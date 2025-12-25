package FixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main
{

	public static void main(String[] args) throws InterruptedException {
		ExecutorService ex=Executors.newFixedThreadPool(3);
		
		for(int i=0;i<=20;i++) {
			MyThread t=new MyThread(i);
			ex.submit(t);
		}
		ex.shutdown();
		ex.awaitTermination(5, TimeUnit.SECONDS);
	}
}
