package com.laptrinhjavaweb.model;
import java.util.Date;

public class Bill {
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
	public Bill(String billid, String method, String note, Date date) {
		super();
		this.billid = billid;
		this.method = method;
		this.note = note;
		this.date = date;
	}
	
	public Bill() {
		super();
	}
	private String billid, method,note;
	 private Date date; 
	 
}
