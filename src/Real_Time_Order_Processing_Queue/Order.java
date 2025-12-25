package Real_Time_Order_Processing_Queue;

import java.time.LocalDateTime;

public class Order {

	private int orderId;
    private String customerName;
    private double amount;
    private LocalDateTime timestamp;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, String customerName, double amount, LocalDateTime timestamp) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", amount=" + amount + ", timestamp="
				+ timestamp + "]";
	}
    
    
}
