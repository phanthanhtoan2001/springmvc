package com.laptrinhjavaweb.model;

import java.util.Date;

public class Coupon {

	
	private String coupon;
	private int discount;
	private Date dateexp;
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coupon(String coupon, int discount, Date dateexp) {
		super();
		this.coupon = coupon;
		this.discount = discount;
		this.dateexp = dateexp;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getDateexp() {
		return dateexp;
	}
	public void setDateexp(Date dateexp) {
		this.dateexp = dateexp;
	}
}
