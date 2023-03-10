package com.laptrinhjavaweb.model;

import java.io.Serializable;
import java.sql.Array;

public class Flower implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Array getCategory() {
		return category;
	}


	public void setCategory(Array category) {
		this.category = category;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private String flowerid, name, color, description, url;
    private Array category;
	int  stock;
	double price;
    public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


    
    public Flower(){
    	super();
    }
    
    
    public Flower(String flowerid,String name,String color,String description,String url, int price, int stock, Array category){
    	super();
    	this.flowerid = flowerid;
    	this.name = name;
    	this.color = color;
    	this.description = description;
    	this.url = url;
    	this.price = price;
    	this.stock = stock;
    	this.category = category;
    }

	public String getFlowerid() {
		return flowerid;
	}

	public void setFlowerid(String flowerid) {
		this.flowerid = flowerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
