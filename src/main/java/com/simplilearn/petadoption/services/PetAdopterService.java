package com.simplilearn.petadoption.services;

import com.simplilearn.petadoption.Models.PetAdopter;
import com.simplilearn.petadoption.repositories.AdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetAdopterService {
	@Autowired
    AdopterRepository adopterRepository;
	public PetAdopter getAdopterById(int adopter_id) {
		return adopterRepository.findById(adopter_id).get();
	}

    public PetAdopter login(String user_email, String user_password) {
		return adopterRepository.login(user_email,user_password);
    }
}
