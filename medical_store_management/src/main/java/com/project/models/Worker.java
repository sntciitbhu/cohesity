package com.project.models;

//import java.sql.Date;

public class Worker  {
	
	private int worker_ID;

	private String aadhar_No;

	private String area;

	private String contact_No;

	private int house_No;

	private String joining_Date;

	private String name;

	private int salary_per__annum;

	private String street;

	private Bank_Detail bankDetail;

	private Medical_Store_Branch medicalStoreBranch;
	
	private int ms_id;
	
	private int bank_detail_id;
	
	private String username;

	public Worker() {
	}

	public int getWorker_ID() {
		return this.worker_ID;
	}

	public void setWorker_ID(int worker_ID) {
		this.worker_ID = worker_ID;
	}

	public String getAadhar_No() {
		return this.aadhar_No;
	}

	public void setAadhar_No(String aadhar_No) {
		this.aadhar_No = aadhar_No;
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

	public int getHouse_No() {
		return this.house_No;
	}

	public void setHouse_No(int house_No) {
		this.house_No = house_No;
	}

	public String getJoining_Date() {
		return this.joining_Date;
	}

	public void setJoining_Date(String joining_Date) {
		this.joining_Date = joining_Date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary_per__annum() {
		return this.salary_per__annum;
	}

	public void setSalary_per__annum(int salary_per__annum) {
		this.salary_per__annum = salary_per__annum;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Bank_Detail getBankDetail() {
		return this.bankDetail;
	}

	public void setBankDetail(Bank_Detail bankDetail) {
		this.bankDetail = bankDetail;
	}

	public Medical_Store_Branch getMedicalStoreBranch() {
		return this.medicalStoreBranch;
	}

	public void setMedicalStoreBranch(Medical_Store_Branch medicalStoreBranch) {
		this.medicalStoreBranch = medicalStoreBranch;
	}
	
	public int getMs_id() {
		return this.ms_id;
	}
	
	public void setMs_id( int ms_id) {
		this.ms_id=ms_id;
	}
	
	public int getBank_detail_id() {
		return this.bank_detail_id;
	}
	
	public void setBank_detail_id( int bank_detail_id) {
		this.bank_detail_id=bank_detail_id;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
