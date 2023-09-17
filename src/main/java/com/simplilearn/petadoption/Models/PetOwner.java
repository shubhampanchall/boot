package com.simplilearn.petadoption.Models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tbl_petowner")
public class PetOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private int ownerId;
    @Column(name = "owner_name")
    private String ownerName;
    @Column(name = "owner_address")
    private String ownerAddress;
    @Column(name = "owner_email")
    private String ownerEmail;
    @Column(name = "owner_password")
    private String ownerPassword;
    @OneToMany
    private List<PetAnimal> petAnimals;

    public PetOwner() {
    }


    public PetOwner(String ownerName, String ownerAddress) {
        super();
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
    }


    public PetOwner(int ownerId, String ownerName, String ownerAddress) {
        super();
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
    }

    public PetOwner(int ownerId, String ownerName, String ownerAddress, String ownerEmail, String ownerPassword, List<PetAnimal> petAnimals) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.ownerAddress = ownerAddress;
        this.ownerEmail = ownerEmail;
        this.ownerPassword = ownerPassword;
        this.petAnimals = petAnimals;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAddress() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }


    public List<PetAnimal> getPetAnimals() {
        return petAnimals;
    }


    public void setPetAnimals(List<PetAnimal> petAnimals) {
        this.petAnimals = petAnimals;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerPassword() {
        return ownerPassword;
    }

    public void setOwnerPassword(String ownerPassword) {
        this.ownerPassword = ownerPassword;
    }
}
