package Java8;

public class UsingJava8 {

	public static void main(String[] args) throws InterruptedException {
		String taskName1 = "File upload";
		String taskName2 = "Read File";
		String taskName3 = "Download File";
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("---------------------------------------");
		
		Thread one =new Thread(()->{
			for(int i=0;i<=5;i++) {
				System.out.println(taskName1+"step:-"+i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread two =new Thread(()->{
			for(int i=0;i<=5;i++) {
				System.out.println(taskName2+"step:-"+i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread three =new Thread(()->{
			for(int i=0;i<=5;i++) {
				System.out.println(taskName3+"step:-"+i);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		one.start();
		one.join();
		two.start();
		two.join();
		three.start();
		three.join();
	}

}
