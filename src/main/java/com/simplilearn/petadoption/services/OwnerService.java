package com.simplilearn.petadoption.services;

import java.util.List;

import com.simplilearn.petadoption.repositories.OwnerRepository;
import com.simplilearn.petadoption.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.petadoption.Models.PetAnimal;
import com.simplilearn.petadoption.Models.PetOwner;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private PetRepository petRepository;
	
	public boolean addNewOwner(PetOwner petOwner) {
		if(petOwner!=null) {
			ownerRepository.save(petOwner);
			return true;
		}
		return false;
	}
	
	public List<PetOwner> getAllOwners(){
		return (List<PetOwner>) ownerRepository.findAll();
	}

	public PetOwner getOwnerById(int ownerId) {
		// TODO Auto-generated method stub
		return ownerRepository.findById(ownerId).get();
	}
	
	public List<PetAnimal> getAnimalsByOwner(int ownerId) {
		// TODO Auto-generated method stub
		return petRepository.getAnimalsByOwner(ownerId);
	}

    public PetOwner login(String ownerEmail, String ownerPassword) {
		PetOwner owner = ownerRepository.login(ownerEmail, ownerPassword);
		return owner;
    }
}
