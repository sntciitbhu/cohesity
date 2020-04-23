package com.project.models;

public class Sold  {
	
	private int product_ID;

	private int transaction_ID;
	
	private int quantity;
	
	public Sold() {
	}

	

	public int getProduct_ID() {
		return this.product_ID;
	}
	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}
	public int getTransaction_ID() {
		return this.transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		this.transaction_ID = transaction_ID;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}
