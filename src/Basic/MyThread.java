package Basic;

public class MyThread implements Runnable {
	/*
	 * You’ll create multiple threads to simulate different tasks (for example,
	 * downloading files or printing numbers). Each thread runs concurrently,
	 * showing how Java executes multiple things at once.
	 */
	private String taskName;

	public MyThread(String taskName) {
		super();
		this.taskName = taskName;
	}

	@Override
	public void run() {
	try {
		for(int i=0;i<=6;i++) {
			 System.out.println(taskName + " - Step " + i);
			 Thread.sleep(300);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
	}

	}

}
