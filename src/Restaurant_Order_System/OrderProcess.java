package Restaurant_Order_System;

import java.util.Random;

public class OrderProcess implements Runnable{
	
	private Order order;
	
	
	
	public OrderProcess(Order order) {
		super();
		this.order = order;
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random random=new Random();
		try {
			System.out.println(Thread.currentThread().getName()+"starting the order #"+order.getOrderId()
			+"->"+"for"+order.getCustomerName());
			int totalTime=1000+random.nextInt(3000);
			Thread.sleep(totalTime);
			double totalAmount=order.getQuantity()*order.getPrice();
			System.out.println("Customer Name"+"->"+order.getCustomerName()+"Order is complited."+"Your Bill is.$"+totalAmount);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
