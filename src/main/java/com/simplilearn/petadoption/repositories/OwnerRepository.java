package com.simplilearn.petadoption.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.petadoption.Models.PetOwner;

@Repository
public interface OwnerRepository extends CrudRepository<PetOwner, Integer> {
    @Query("select a from PetOwner a where a.ownerEmail = ?1 and a.ownerPassword = ?2")
    PetOwner login(String ownerEmail, String ownerPassword);
}
