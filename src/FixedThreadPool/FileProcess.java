package FixedThreadPool;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileProcess {

	public void fileProcess(String fileName) {
		try {
			
			System.out.println(Thread.currentThread().getName()+"-"+fileName+"is processing");
			Random random=new Random();
			int totalTime=100+random.nextInt(2000);
			for(int progress=10 ; progress<=100 ; progress+=10) {
				
				Thread.sleep(totalTime/10);
				System.out.println(Thread.currentThread().getName() + "-->"+fileName+"  | proress-"+progress+" %");
			}
            System.out.println(Thread.currentThread().getName() + " ✅ Finished processing " + fileName);

		} catch (Exception e) {
			System.out.println("Error in file "+fileName);
		}
	}
	
	public static void main(String[] args) {
		
		List<String>files=Arrays.asList("file-1","file-2","file-3","file-4","file-5","file-6","file-7","file-8");
		
		ExecutorService executor=Executors.newFixedThreadPool(3);
		
		FileProcess process=new FileProcess();
		
		try {
			files.forEach(file->{
				executor.submit(()->process.fileProcess(file));
			});
			
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
			System.out.println("All file are processing complited..");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
