package com.laptrinhjavaweb.model;

public class Order {

	
	private String orderid,flowerid,userid,shipaddress;
	private int quantity;
	public Order() {
		super();
	}
	public Order(String orderid, String flowerid, String userid, String shipaddress, int quantity) {
		super();
		this.orderid = orderid;
		this.flowerid = flowerid;
		this.userid = userid;
		this.shipaddress = shipaddress;
		this.quantity = quantity;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getFlowerid() {
		return flowerid;
	}
	public void setFlowerid(String flowerid) {
		this.flowerid = flowerid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getShipaddress() {
		return shipaddress;
	}
	public void setShipaddress(String shipaddress) {
		this.shipaddress = shipaddress;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
