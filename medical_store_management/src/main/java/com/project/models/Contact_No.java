package com.project.models;

public class Contact_No  {
	private Contact_NoPK id;

	private Medical_Store_Branch medicalStoreBranch;

	public Contact_No() {
	}

	public Contact_NoPK getId() {
		return this.id;
	}

	public void setId(Contact_NoPK id) {
		this.id = id;
	}

	public Medical_Store_Branch getMedicalStoreBranch() {
		return this.medicalStoreBranch;
	}

	public void setMedicalStoreBranch(Medical_Store_Branch medicalStoreBranch) {
		this.medicalStoreBranch = medicalStoreBranch;
	}

}
