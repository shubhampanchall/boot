package com.simplilearn.petadoption.Models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_application")
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="application_id")
	private int applicationId;
	
	@ManyToOne
	private PetAnimal petAnimal;
	
	@ManyToOne
	private PetAdopter petAdopter;
//	
	@Column(name="application_date")
	private Date applicationDate;
//	
	

	public Application() {
		super();
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public PetAnimal getPetAnimal() {
		return petAnimal;
	}

	public void setPetAnimal(PetAnimal petAnimal) {
		this.petAnimal = petAnimal;
	}

	public PetAdopter getPetAdopter() {
		return petAdopter;
	}

	public void setPetAdopter(PetAdopter petAdopter) {
		this.petAdopter = petAdopter;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationdate) {
		this.applicationDate = applicationdate;
	}
	
	
}
