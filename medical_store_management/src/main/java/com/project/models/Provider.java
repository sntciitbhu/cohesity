package com.project.models;

import java.util.List;

public class Provider  {
	private int provider_ID;

	private String area;

	private String contact_No;

	private int godown_No;

	private String provider_Name;

	private String street;

	private List<Buying__Transaction> buyingTransactions;

	private Bank_Detail bankDetail;
	
	private int bank_detail_id;

	//bi-directional many-to-many association to Product
/*	@ManyToMany
	@JoinTable(
		name="Provides"
		, joinColumns={
			@JoinColumn(name="Provider_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Product_ID")
			}
		)*/
	private List<Product> products;

	public Provider() {
	}

	public int getProvider_ID() {
		return this.provider_ID;
	}

	public void setProvider_ID(int provider_ID) {
		this.provider_ID = provider_ID;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getContact_No() {
		return this.contact_No;
	}

	public void setContact_No(String contact_No) {
		this.contact_No = contact_No;
	}

	public int getGodown_No() {
		return this.godown_No;
	}

	public void setGodown_No(int godown_No) {
		this.godown_No = godown_No;
	}

	public String getProvider_Name() {
		return this.provider_Name;
	}

	public void setProvider_Name(String provider_Name) {
		this.provider_Name = provider_Name;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Buying__Transaction> getBuyingTransactions() {
		return this.buyingTransactions;
	}

	public void setBuyingTransactions(List<Buying__Transaction> buyingTransactions) {
		this.buyingTransactions = buyingTransactions;
	}

	
	public Bank_Detail getBankDetail() {
		return this.bankDetail;
	}

	public void setBankDetail(Bank_Detail bankDetail) {
		this.bankDetail = bankDetail;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public int getBank_detail_id() {
		return this.bank_detail_id;
	}

	public void setBank_detail_id(int bank_detail_id) {
		this.bank_detail_id = bank_detail_id;
	}

}
