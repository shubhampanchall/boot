package com.simplilearn.petadoption.services;

import java.util.List;

import com.simplilearn.petadoption.Models.Application;
import com.simplilearn.petadoption.repositories.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	public Application saveApplication(Application application) {
		return applicationRepository.save(application);
	}



	public List<Application> getApplicationByAdopter(int adopterId) {
		return applicationRepository.findByPetAdopter_AdopterId(adopterId);
	}

    public List<Application> getApplicationByOwner(int ownerId) {
		return applicationRepository.findByPetOwner(ownerId);
    }
}
