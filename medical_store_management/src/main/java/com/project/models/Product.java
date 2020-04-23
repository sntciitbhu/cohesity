package com.project.models;
import java.util.List;
public class Product  {
	private int product_ID;
	private String company_Name;

	private int MRP_per_unit;

	private String name;

	private List<Bought> boughts;

	private List<In_Stock> inStocks;

	private List<Doctor> doctors;

	private Category category;

	private List<Provider> providers;

	private List<Sold> solds;

	private List<Product> products1;

	private List<Product> products2;
	
	private int category_id;

	public Product() {
	}

	public int getProduct_ID() {
		return this.product_ID;
	}

	public void setProduct_ID(int product_ID) {
		this.product_ID = product_ID;
	}

	public String getCompany_Name() {
		return this.company_Name;
	}

	public void setCompany_Name(String company_Name) {
		this.company_Name = company_Name;
	}

	public int getMRP_per_unit() {
		return this.MRP_per_unit;
	}

	public void setMRP_per_unit(int MRP_per_unit) {
		this.MRP_per_unit = MRP_per_unit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Bought> getBoughts() {
		return this.boughts;
	}

	public void setBoughts(List<Bought> boughts) {
		this.boughts = boughts;
	}

	
	public List<In_Stock> getInStocks() {
		return this.inStocks;
	}

	public void setInStocks(List<In_Stock> inStocks) {
		this.inStocks = inStocks;
	}

	public In_Stock addInStock(In_Stock inStock) {
		getInStocks().add(inStock);
		inStock.setProduct_ID(this.product_ID);

		return inStock;
	}

	public In_Stock removeInStock(In_Stock inStock) {
		getInStocks().remove(inStock);
		inStock.setProduct_ID(0);

		return inStock;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Provider> getProviders() {
		return this.providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public List<Sold> getSolds() {
		return this.solds;
	}

	public void setSolds(List<Sold> solds) {
		this.solds = solds;
	}

	public List<Product> getProducts1() {
		return this.products1;
	}

	public void setProducts1(List<Product> products1) {
		this.products1 = products1;
	}

	public List<Product> getProducts2() {
		return this.products2;
	}

	public void setProducts2(List<Product> products2) {
		this.products2 = products2;
	}
	public int getCategory_id() {
		return this.category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

}
