package com.project.models;

import java.util.Date;
import java.util.List;

public class Selling__Transaction  {
	
	private int transaction_ID;

	private String date;

	private int total_Bill;

	private int customer_id;

	private  int MS_id;

	private int Doctor_ID;
	
	private int product_no;
	
	public Selling__Transaction() {
	}

	public int getTransaction_ID() {
		return this.transaction_ID;
	}

	public void setTransaction_ID(int transaction_ID) {
		this.transaction_ID = transaction_ID;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotal_Bill() {
		return this.total_Bill;
	}

	public void setTotal_Bill(int total_Bill) {
		this.total_Bill = total_Bill;
	}

	public int getCustomer_id() {
		return this.customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getMS_id() {
		return this.MS_id;
	}

	public void setMS_id(int MS_id) {
		this.MS_id = MS_id;
	}
	
	public int getDoctor_ID() {
		return this.Doctor_ID;
	}

	public void setDoctor_ID(int Doctor_ID) {
		this.Doctor_ID = Doctor_ID;
	}
	
	public int getProduct_no() {
		return this.product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

}
