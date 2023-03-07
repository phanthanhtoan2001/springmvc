package com.laptrinhjavaweb.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Bill {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public String getBillid() {
		return billid;
	}

	public void setBillid(String billid) {
		this.billid = billid;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Bill() {
		super();
	}

	public Bill(String billid, String method, String note, Date date, String orderid) {
		super();
		this.billid = billid;
		this.method = method;
		this.note = note;
		this.date = date;
		this.orderid = orderid;
	}

	private String billid, method, note, orderid;

	private Date date;

}
