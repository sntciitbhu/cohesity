package com.project.models;

import java.util.Date;
import java.util.List;


public class Buying__Transaction  {
	
	private int transaction_ID;

	private String date;

	private int total_Bill;

	private int ms_id;

	private int provider_id;

	public Buying__Transaction() {
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

	public int getMs_id() {
		return this.ms_id;
	}

	public void setMs_id(int ms_id) {
		this.ms_id = ms_id;
	}
	public int getProvider_id() {
		return this.provider_id;
	}

	public void setProvider_id(int provider_id) {
		this.provider_id = provider_id;
	}

}
