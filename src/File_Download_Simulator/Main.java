package File_Download_Simulator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		List<String> fileNames = Arrays.asList("File-A.zip", "File-B.mp4", "File-C.pdf", "File-D.jpg", "File-E.mp3");
		
		
		// traditinal way 
//		fileNames.forEach(file->{
//			Thread t=new Thread(new FileDownload(file));
//			t.start();
//		});
		
		
		
		//------------------------------
		//ExecutorService without lambda
		
		ExecutorService executor=Executors.newFixedThreadPool(3);
		
		fileNames.forEach(file->{
			executor.submit(new FileDownload(file));
		});
		
		executor.shutdown();
		executor.awaitTermination(5, TimeUnit.SECONDS);
		System.out.println("All files are download.....");
		
	}
}
