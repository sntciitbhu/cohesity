package com.project.models;
import java.util.List;
public class Medical_Store_Branch  {
	
	private int MS_Id;

	private String area;

	private int head_Worker_id;

	private String major_Location;

	private int shop_No;

	private String street;

	//bi-directional many-to-many association to Doctor
	/*@ManyToMany
	@JoinTable(
		name="Affiliated_To"
		, joinColumns={
			@JoinColumn(name="MS_Id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="Doctor_ID")
			}
		)*/
	private List<Doctor> doctors;

	private List<Buying__Transaction> buyingTransactions;

	private List<Contact_No> contactNos;

	private List<In_Stock> inStocks;

	private List<Selling__Transaction> sellingTransactions;

	private List<Worker> workers;

	public Medical_Store_Branch() {
	}

	public int getMS_Id() {
		return this.MS_Id;
	}

	public void setMS_Id(int MS_Id) {
		this.MS_Id = MS_Id;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getHead_Worker_id() {
		return this.head_Worker_id;
	}

	public void setHead_Worker_id(int head_Worker_ID) {
		this.head_Worker_id = head_Worker_ID;
	}

	public String getMajor_Location() {
		return this.major_Location;
	}

	public void setMajor_Location(String major_Location) {
		this.major_Location = major_Location;
	}

	public int getShop_No() {
		return this.shop_No;
	}

	public void setShop_No(int shop_No) {
		this.shop_No = shop_No;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Buying__Transaction> getBuyingTransactions() {
		return this.buyingTransactions;
	}

	public void setBuyingTransactions(List<Buying__Transaction> buyingTransactions) {
		this.buyingTransactions = buyingTransactions;
	}

	
	public List<Contact_No> getContactNos() {
		return this.contactNos;
	}

	public void setContactNos(List<Contact_No> contactNos) {
		this.contactNos = contactNos;
	}

	public Contact_No addContactNo(Contact_No contactNo) {
		getContactNos().add(contactNo);
		contactNo.setMedicalStoreBranch(this);

		return contactNo;
	}

	public Contact_No removeContactNo(Contact_No contactNo) {
		getContactNos().remove(contactNo);
		contactNo.setMedicalStoreBranch(null);

		return contactNo;
	}

	public List<In_Stock> getInStocks() {
		return this.inStocks;
	}

	public void setInStocks(List<In_Stock> inStocks) {
		this.inStocks = inStocks;
	}

	public In_Stock addInStock(In_Stock inStock) {
		getInStocks().add(inStock);
		inStock.setMS_Id(this.MS_Id);

		return inStock;
	}

	public In_Stock removeInStock(In_Stock inStock) {
		getInStocks().remove(inStock);
		inStock.setMS_Id(0);

		return inStock;
	}

	public List<Selling__Transaction> getSellingTransactions() {
		return this.sellingTransactions;
	}

	public void setSellingTransactions(List<Selling__Transaction> sellingTransactions) {
		this.sellingTransactions = sellingTransactions;
	}

	public List<Worker> getWorkers() {
		return this.workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public Worker addWorker(Worker worker) {
		getWorkers().add(worker);
		worker.setMedicalStoreBranch(this);

		return worker;
	}

	public Worker removeWorker(Worker worker) {
		getWorkers().remove(worker);
		worker.setMedicalStoreBranch(null);

		return worker;
	}

}
