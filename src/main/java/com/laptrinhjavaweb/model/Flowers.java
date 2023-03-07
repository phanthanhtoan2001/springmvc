package com.laptrinhjavaweb.model;

import java.io.Serializable;

public class Flowers implements Serializable {
	private static final long serialVersionUID = 1L;

	private String flowerid, name, description, image;
	private int stock;
	private double price;
	public Flowers() {
		super();
	}

	public Flowers(String flowerid, String name, String description, String image, int stock, double price) {
		super();
		this.flowerid = flowerid;
		this.name = name;
		this.description = description;
		this.image = image;
		this.stock = stock;
		this.price = price;
	}

	public String getflowerid() {
		return flowerid;
	}

	public void setflowerid(String flowerid) {
		this.flowerid = flowerid;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String getimage() {
		return image;
	}

	public void setimage(String image) {
		this.image = image;
	}

	public int getstock() {
		return stock;
	}

	public void setstock(int stock) {
		this.stock = stock;
	}

	public double getprice() {
		return price;
	}

	public void setprice(double price) {
		this.price = price;
	}

	
}
