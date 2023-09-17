package com.simplilearn.petadoption.repositories;

import com.simplilearn.petadoption.Models.PetAdopter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdopterRepository extends CrudRepository<PetAdopter,Integer>{
    @Query("select p from PetAdopter p where p.adopterEmail = ?1 and p.adopterPassword = ?2")
    PetAdopter login(String adopterEmail, String adopterPassword);

}
