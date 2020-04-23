package com.project.models;
import java.util.List;

public class Bank_Detail  {
	private int bank_Detail_ID;

	private String account_No;

	private String IFSC_Code;

	private List<Doctor> doctors;

	private List<Provider> providers;

	private List<Worker> workers;

	public Bank_Detail() {
	}

	public int getBank_Detail_ID() {
		return this.bank_Detail_ID;
	}

	public void setBank_Detail_ID(int bank_Detail_ID) {
		this.bank_Detail_ID = bank_Detail_ID;
	}

	public String getAccount_No() {
		return this.account_No;
	}

	public void setAccount_No(String account_No) {
		this.account_No = account_No;
	}

	public String getIFSC_Code() {
		return this.IFSC_Code;
	}

	public void setIFSC_Code(String IFSC_Code) {
		this.IFSC_Code = IFSC_Code;
	}

	public List<Doctor> getDoctors() {
		return this.doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Doctor addDoctor(Doctor doctor) {
		getDoctors().add(doctor);
		doctor.setBankDetail(this);

		return doctor;
	}

	public Doctor removeDoctor(Doctor doctor) {
		getDoctors().remove(doctor);
		doctor.setBankDetail(null);

		return doctor;
	}

	public List<Provider> getProviders() {
		return this.providers;
	}

	public void setProviders(List<Provider> providers) {
		this.providers = providers;
	}

	public Provider addProvider(Provider provider) {
		getProviders().add(provider);
		provider.setBankDetail(this);

		return provider;
	}

	public Provider removeProvider(Provider provider) {
		getProviders().remove(provider);
		provider.setBankDetail(null);

		return provider;
	}

	public List<Worker> getWorkers() {
		return this.workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public Worker addWorker(Worker worker) {
		getWorkers().add(worker);
		worker.setBankDetail(this);

		return worker;
	}

	public Worker removeWorker(Worker worker) {
		getWorkers().remove(worker);
		worker.setBankDetail(null);

		return worker;
	}

}
