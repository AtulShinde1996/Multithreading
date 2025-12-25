package FixedThreadPool;

public class MyThread implements Runnable {
	private  int taskId;
	
	
	
	public MyThread(int taskId) {
		super();
		this.taskId = taskId;
	}



	public int getTaskId() {
		return taskId;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread:-"+Thread.currentThread().getName()+"->"+"task"+taskId);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
