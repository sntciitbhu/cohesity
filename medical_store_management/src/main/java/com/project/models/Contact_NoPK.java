package com.project.models;

public class Contact_NoPK  {
	private int contact_No;

	private int MS_Id;

	public Contact_NoPK() {
	}
	public int getContact_No() {
		return this.contact_No;
	}
	public void setContact_No(int contact_No) {
		this.contact_No = contact_No;
	}
	public int getMS_Id() {
		return this.MS_Id;
	}
	public void setMS_Id(int MS_Id) {
		this.MS_Id = MS_Id;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Contact_NoPK)) {
			return false;
		}
		Contact_NoPK castOther = (Contact_NoPK)other;
		return 
			(this.contact_No == castOther.contact_No)
			&& (this.MS_Id == castOther.MS_Id);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.contact_No;
		hash = hash * prime + this.MS_Id;
		
		return hash;
	}
}
