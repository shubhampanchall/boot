package com.simplilearn.petadoption.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_adopter")
public class PetAdopter {
    @Id
    @Column(name = "adopter_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adopterId;
    @Column(name = "adopter_name")
    private String adopterName;
    @Column(name = "adopter_address")
    private String adopterAddress;

    @Column(name = "adopter_email")
    private String adopterEmail;

    @Column(name = "adopter_mobile")
    private String adopterMobile;

    @Column(name = "adopter_password")
    private String adopterPassword;

    public PetAdopter() {
    }

    public int getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }

    public String getAdopterAddress() {
        return adopterAddress;
    }

    public void setAdopterAddress(String adopterAddress) {
        this.adopterAddress = adopterAddress;
    }

    public String getAdopterEmail() {
        return adopterEmail;
    }

    public String getAdopterMobile() {
        return adopterMobile;
    }

    public void setAdopterMobile(String adopterMobile) {
        this.adopterMobile = adopterMobile;
    }

    public void setAdopterEmail(String adopterEmail) {
        this.adopterEmail = adopterEmail;
    }

    public String getAdopterPassword() {
        return adopterPassword;
    }

    public void setAdopterPassword(String adopterPassword) {
        this.adopterPassword = adopterPassword;
    }
}
