package File_Download_Simulator;

import java.util.Random;

public class FileDownload implements Runnable{

	private String fileName;
	
	
	
	public FileDownload(String fileName) {
		super();
		this.fileName = fileName;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " started downloading: " + fileName);
		try {
			Random random = new Random();
			int downloadTime = 200 + random.nextInt(300);
			for (int progress = 10; progress <= 100; progress += 10) {
                Thread.sleep(downloadTime / 10); // divide total time into 10 steps
                System.out.println(Thread.currentThread().getName() + " → " + fileName +
                        " progress: " + progress + "%");
            }
			//Thread.sleep(downloadTime);
			System.out.println(Thread.currentThread().getName() + " finish downloading: " + fileName);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
