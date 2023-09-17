package com.simplilearn.petadoption.dto;

import java.util.Date;

public class ApplicationDTO {
	int applicationId;
	String adopterName;
	String petName;
	String petOwner;
	Date applicationDate;
	public ApplicationDTO() {
		super();
	}
	public ApplicationDTO(int applicationId, String adopterName, String petName, Date applicationDate) {
		super();
		this.applicationId = applicationId;
		this.adopterName = adopterName;
		this.petName = petName;
		this.applicationDate = applicationDate;
	}
	
	
	public ApplicationDTO(int applicationId, String adopterName, String petName, String petOwner,
			Date applicationDate) {
		super();
		this.applicationId = applicationId;
		this.adopterName = adopterName;
		this.petName = petName;
		this.petOwner = petOwner;
		this.applicationDate = applicationDate;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getAdopterName() {
		return adopterName;
	}
	public void setAdopterName(String adopterName) {
		this.adopterName = adopterName;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getPetOwner() {
		return petOwner;
	}
	public void setPetOwner(String petOwner) {
		this.petOwner = petOwner;
	}
	
	
}
