package com.laptrinhjavaweb.model;

public class Item {

	private Flower flower;
	private int quantity;

	public Flower getFlower() {
		return flower;
	}

	public void setFlower(Flower Flower) {
		this.flower = Flower;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item() {
	}

	public Item(Flower Flower, int quantity) {
		this.flower = Flower;
		this.quantity = quantity;
	}
}
