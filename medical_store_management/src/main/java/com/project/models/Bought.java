package com.project.models;
public class Bought  {
	
	private int product_ID;

	private int transaction_ID;

	private int cost_Price_per_Unit;

	private int quantity;


	public Bought() {
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

	public int getCost_Price_per_Unit() {
		return this.cost_Price_per_Unit;
	}

	public void setCost_Price_per_Unit(int cost_Price_per_Unit) {
		this.cost_Price_per_Unit = cost_Price_per_Unit;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
