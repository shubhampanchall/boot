package com.simplilearn.petadoption.repositories;

import com.simplilearn.petadoption.Models.Application;
import com.simplilearn.petadoption.dto.ApplicationDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application,Integer>{
	
	@Query("SELECT new com.simplilearn.petadoption.dto.ApplicationDTO(ap.applicationId,ad.adopterName,pet.petName,ap.applicationDate) FROM Application ap INNER JOIN ap.petAdopter ad INNER JOIN ap.petAnimal pet ")
	public List<ApplicationDTO> getAppData();

	@Query("select a from Application a where a.petAdopter.adopterId = ?1")
	List<Application> findByPetAdopter_AdopterId(int adopterId);

    @Query("select a from Application a where a.petAnimal.petOwner.ownerId = ?1")
    List<Application> findByPetOwner(int ownerId);
	

}
