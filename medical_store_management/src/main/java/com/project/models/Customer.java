package com.project.models;
import java.util.List;
public class Customer  {
	private int customer_ID;

	private String contact_No;

	private String name;

	private List<Selling__Transaction> sellingTransactions;

	public Customer() {
	}

	public int getCustomer_ID() {
		return this.customer_ID;
	}

	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}

	public String getContact_No() {
		return this.contact_No;
	}

	public void setContact_No(String contact_No) {
		this.contact_No = contact_No;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Selling__Transaction> getSellingTransactions() {
		return this.sellingTransactions;
	}

	public void setSellingTransactions(List<Selling__Transaction> sellingTransactions) {
		this.sellingTransactions = sellingTransactions;
	}

}
