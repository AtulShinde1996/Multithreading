package Basic;

public class Test {

	public static void main(String[] args) {
		Thread t1=new Thread(new MyThread("Upload File"));
		Thread t2=new Thread(new MyThread("Read File"));
		Thread t3=new Thread(new MyThread("download File"));
		
		t1.start();
		t2.start();
		t3.start();

	}

}
