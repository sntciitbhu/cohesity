package com.project.models;
import java.util.List;

public class Doctor  {
	private int doctor_ID;

	private String clinic_Name;

	private int commision_per__recommendation;

	private String contact_No;

	private String major_Location;

	private String name;

	private List<Medical_Store_Branch> medicalStoreBranches;

	private Bank_Detail bankDetail;
	
	private int bank_detail_id;
	
	private List<Product> products;

	
	public Doctor() {
	}

	public int getDoctor_ID() {
		return this.doctor_ID;
	}

	public void setDoctor_ID(int doctor_ID) {
		this.doctor_ID = doctor_ID;
	}

	public String getClinic_Name() {
		return this.clinic_Name;
	}

	public void setClinic_Name(String clinic_Name) {
		this.clinic_Name = clinic_Name;
	}

	public int getCommision_per__recommendation() {
		return this.commision_per__recommendation;
	}

	public void setCommision_per__recommendation(int commision_per__recommendation) {
		this.commision_per__recommendation = commision_per__recommendation;
	}

	public String getContact_No() {
		return this.contact_No;
	}

	public void setContact_No(String contact_No) {
		this.contact_No = contact_No;
	}

	public String getMajor_Location() {
		return this.major_Location;
	}

	public void setMajor_Location(String major_Location) {
		this.major_Location = major_Location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Medical_Store_Branch> getMedicalStoreBranches() {
		return this.medicalStoreBranches;
	}

	public void setMedicalStoreBranches(List<Medical_Store_Branch> medicalStoreBranches) {
		this.medicalStoreBranches = medicalStoreBranches;
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
