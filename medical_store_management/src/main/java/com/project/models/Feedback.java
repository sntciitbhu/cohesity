package com.project.models;


public class Feedback  {
	
	private int feedback_Id;

	private String comment;

	private int product_Satisfaction;

	private int service_Satisfaction;

	private Selling__Transaction sellingTransaction;

	public Feedback() {
	}

	public int getFeedback_Id() {
		return this.feedback_Id;
	}

	public void setFeedback_Id(int feedback_Id) {
		this.feedback_Id = feedback_Id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getProduct_Satisfaction() {
		return this.product_Satisfaction;
	}

	public void setProduct_Satisfaction(int product_Satisfaction) {
		this.product_Satisfaction = product_Satisfaction;
	}

	public int getService_Satisfaction() {
		return this.service_Satisfaction;
	}

	public void setService_Satisfaction(int service_Satisfaction) {
		this.service_Satisfaction = service_Satisfaction;
	}

	public Selling__Transaction getSellingTransaction() {
		return this.sellingTransaction;
	}

	public void setSellingTransaction(Selling__Transaction sellingTransaction) {
		this.sellingTransaction = sellingTransaction;
	}

}
