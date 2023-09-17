package com.simplilearn.petadoption.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_pet")
public class PetAnimal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pet_id")
	private int petId;
	
	@Column(name = "pet_name")
	private String petName;
	
	@Column(name = "pet_category")
	private String petCategory;
	
	@Column(name = "pet_age")
	private int petAge;
	
	@Column(name = "pet_gender")
	private String petGender;
	
	@Column(name = "pet_breed")
	private String petBreed;
	
	@Column(name = "pet_status")
	private boolean petStatus;
	
	@ManyToOne
	@JoinColumn(name="petowner_id")
	private PetOwner petOwner;
	
	public PetAnimal() {
		super();
	}

	public PetAnimal(int petId, String petName, String petCategory, int petAge, String petGender, String petBreed,
			boolean petStatus) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petCategory = petCategory;
		this.petAge = petAge;
		this.petGender = petGender;
		this.petBreed = petBreed;
		this.petStatus = petStatus;
	}

	public PetAnimal(String petName, String petCategory, int petAge, String petGender, String petBreed,
			boolean petStatus) {
		super();
		this.petName = petName;
		this.petCategory = petCategory;
		this.petAge = petAge;
		this.petGender = petGender;
		this.petBreed = petBreed;
		this.petStatus = petStatus;
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

	public String getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	public String getPetBreed() {
		return petBreed;
	}

	public void setPetBreed(String petBreed) {
		this.petBreed = petBreed;
	}

	public boolean isPetStatus() {
		return petStatus;
	}

	public void setPetStatus(boolean petStatus) {
		this.petStatus = petStatus;
	}

	public PetOwner getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(PetOwner petOwner) {
		this.petOwner = petOwner;
	}

}
