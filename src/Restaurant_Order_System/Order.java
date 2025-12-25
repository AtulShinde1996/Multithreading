package Restaurant_Order_System;

public class Order {

	private int orderId;
    private String customerName;
    private String itemName;
    private int quantity;
    private double price;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, String customerName, String itemName, int quantity, double price) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", itemName=" + itemName + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
    
    
}
