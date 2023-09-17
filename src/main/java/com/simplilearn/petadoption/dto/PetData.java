package com.simplilearn.petadoption.dto;

public class PetData {
	int petId;
	String petName;
	int petAge;
	
	public PetData(int petId, String petName,int petAge) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petAge = petAge;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}
	
	
}
