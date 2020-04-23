package com.project.models;

//import java.util.Date;

public class In_Stock  {

	private int Product_ID;

	private String batch_No;

	private String expiry_Date;

	private int quantity;

	private int MS_Id;
	
	public In_Stock() {
	}

	public int getProduct_ID() {
		return this.Product_ID;
	}

	public void setProduct_ID(int Product_ID) {
		this.Product_ID = Product_ID;
	}

	public String getBatch_No() {
		return this.batch_No;
	}

	public void setBatch_No(String batch_No) {
		this.batch_No = batch_No;
	}

	public String getExpiry_Date() {
		return this.expiry_Date;
	}

	public void setExpiry_Date(String expiry_Date) {
		this.expiry_Date = expiry_Date;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMS_Id() {
		return this.MS_Id;
	}

	public void setMS_Id(int MS_Id) {
		this.MS_Id = MS_Id;
	}


}
