package wait_And_Notify;

public class waitAndNotifyThread {

	private static final Object lock = new Object();

	public static void main(String[] args) { //IllegalMonitorStateException.

		Thread one = new Thread(() -> {
			try {
				synchronized (lock) {
					System.out.println("thread one is provessing.....");
					lock.wait();
					System.out.println("Thread One: Got notification! Resuming work...");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		Thread two = new Thread(() -> {
			try {
				synchronized (lock) {
					System.out.println("Thread two in notifying....");
					lock.notify();
					System.out.println(
							"after calling notiy ,notify method is do not lose contoller directly it can process synchorized block. ");
					
				}
			} catch (Exception e) {

			}
		});
		
		Runnable three=()->{
			try {
				synchronized (lock) {
					System.out.println("Thread three in notifying....");
					lock.notify();
					System.out.println(
							" three process synchorized block. ");
					
				}
			} catch (Exception e) {

			}
		};
		one.start();
		two.start();
		Thread t=new Thread(three);
		t.start();
	}
}
