package com.simplilearn.petadoption.controllers;

import java.util.ArrayList;
import java.util.List;

import com.simplilearn.petadoption.Models.Application;
import com.simplilearn.petadoption.Models.PetAdopter;
import com.simplilearn.petadoption.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.simplilearn.petadoption.Models.PetAnimal;
import com.simplilearn.petadoption.Models.PetOwner;
import com.simplilearn.petadoption.services.ApplicationService;
import com.simplilearn.petadoption.services.PetAdopterService;
import com.simplilearn.petadoption.services.PetService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@RestController
@Controller
@RequestMapping("/owner")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;

    @Autowired
    PetService petService;

    @Autowired
    private PetAdopterService petAdopterService;

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/")
    private String home(ModelMap modelMap) {
        modelMap.addAttribute("pagetitle", "Login");
        modelMap.addAttribute("user", "Owner");
        return "login";
    }

    @RequestMapping("/login")
    private String login(ModelMap modelMap,
                         HttpServletRequest request,
                         @RequestParam(value = "user_email", required = true) String user_email,
                         @RequestParam(value = "user_password", required = true) String user_password) {
        modelMap.addAttribute("pagetitle", "Login");
        PetOwner owner = ownerService.login(user_email, user_password);
        if (owner == null) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid Credentials! Please try again.");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("ownerId", owner.getOwnerId());
        session.setAttribute("userName", owner.getOwnerName());
        session.setAttribute("user", "owner");
        return "redirect:/owner/pets";
    }

    @RequestMapping("/pets")
    public String getAnimals(ModelMap modelMap) {
        List<PetAnimal> petAnimalList = new ArrayList<>();
        petAnimalList = ownerService.getAnimalsByOwner(1);
        modelMap.addAttribute("pets", petAnimalList);
        modelMap.addAttribute("message", "Total " + petAnimalList.size() + " records found.");
        return "pet-list-owner";
    }

    @RequestMapping("/pets/{pet_id}")
    public String getAnimalById(ModelMap modelMap, @PathVariable int pet_id) {
        PetAnimal pet = null;
        try {
            pet = petService.getAnimalById(pet_id);
        } catch (Exception ex) {
            pet = new PetAnimal();
        }
        modelMap.addAttribute("pet", pet);
        return "pet-single-owner";
    }

    @RequestMapping("/pets/add-new")
    public String addNewPet(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        String[] pet_category = {"Cat", "Dog"};
        modelMap.addAttribute("pet_category", pet_category);
        return "add-pet";
    }

    @PostMapping("/pets/add")
    public String addNew(HttpServletRequest request,
                         @RequestParam("pet_name") String petName,
                         @RequestParam("pet_category") String petCategory,
                         @RequestParam("pet_age") int petAge,
                         @RequestParam("pet_gender") String petGender,
                         @RequestParam("pet_breed") String petBreed) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }

        int ownerId = (int) session.getAttribute("ownerId");
        PetOwner petOwner = ownerService.getOwnerById(ownerId);
        PetAnimal petAnimal = new PetAnimal(petName, petCategory, petAge, petGender, petBreed, true);
        petAnimal.setPetOwner(petOwner);
        petService.addNew(petAnimal);
        return "redirect:/owner/pets/";
    }

    @RequestMapping("/pets/edit-pet/{pet_id}")
    public String edit(ModelMap modelMap, @PathVariable int pet_id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        String[] pet_category = {"Cat", "Dog"};
        modelMap.addAttribute("pet_category", pet_category);
        PetAnimal petAnimal = petService.getAnimalById(pet_id);
        modelMap.addAttribute("pet", petAnimal);
        return "edit-pet";
    }

    @RequestMapping(value = "/pets/edit", method = RequestMethod.POST)
    public String edit(HttpServletRequest request,
                       @RequestParam("pet_id") int petId,
                       @RequestParam("pet_name") String petName,
                       @RequestParam("pet_category") String petCategory,
                       @RequestParam("pet_age") int petAge,
                       @RequestParam("pet_gender") String petGender,
                       @RequestParam("pet_status") boolean petStatus,
                       @RequestParam("pet_breed") String petBreed) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        int ownerId = (int) session.getAttribute("ownerId");
        PetAnimal petAnimal = new PetAnimal(petId, petName, petCategory, petAge, petGender, petBreed, petStatus);
        PetOwner petOwner = ownerService.getOwnerById(ownerId);
        petAnimal.setPetOwner(petOwner);
        petService.addNew(petAnimal);
        return "redirect:/owner/pets/";
    }

    @RequestMapping("/pets/delete/{pet_id}")
    public String deletePet(ModelMap modelMap,
                            HttpServletRequest request,
                            @PathVariable("pet_id") int petId) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        int ownerId = (int) session.getAttribute("ownerId");
        PetAnimal pet = petService.getAnimalById(petId);
        if (pet.isPetStatus()) {
            petService.deletePetAnimal(petId);
            return "redirect:/owner/pets/";
        }
        modelMap.addAttribute("error", true);
        modelMap.addAttribute("message", "ADOPTED PET CAN NOT BE DELETED.");
        return "pet-list";
    }

    @RequestMapping("/application")
    public String getApplicationData(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("ownerId") == null) {
            return "redirect:/owner/";
        }
        int ownerId = (int) session.getAttribute("ownerId");
        List<Application> applications = new ArrayList<>();
        applications = applicationService.getApplicationByOwner(ownerId);
        modelMap.addAttribute("applications", applications);
        modelMap.addAttribute("message", "Total " + applications.size() + " records found.");
        return "applications-owner";
    }

    @RequestMapping("/adopter/{adopterId}")
    public String getAdopterById(ModelMap modelMap, @PathVariable int adopterId) {
        PetAdopter petAdopter = null;
        try {
            petAdopter = petAdopterService.getAdopterById(adopterId);
        } catch (Exception ex) {
            petAdopter = new PetAdopter();
        }
        modelMap.addAttribute("adopter", petAdopter);
        return "pet-adopter";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
