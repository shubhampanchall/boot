package com.simplilearn.petadoption.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.simplilearn.petadoption.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.simplilearn.petadoption.Models.Application;
import com.simplilearn.petadoption.Models.PetAdopter;
import com.simplilearn.petadoption.Models.PetAnimal;
import com.simplilearn.petadoption.services.ApplicationService;
import com.simplilearn.petadoption.services.PetAdopterService;
import com.simplilearn.petadoption.services.PetService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@RestController
@Controller
@RequestMapping(path = "/adopter")
public class PetController {
    @Autowired
    PetService petService;

    @Autowired
    OwnerService ownerService;

    @Autowired
    private PetAdopterService petAdopterService;

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/")
    private String home(ModelMap modelMap) {
        modelMap.addAttribute("pagetitle", "Login");
        modelMap.addAttribute("user", "Adopter");
        return "login";
    }

    @RequestMapping("/login")
    private String login(ModelMap modelMap,
                         HttpServletRequest request,
                         @RequestParam(value = "user_email", required = true) String user_email,
                         @RequestParam(value = "user_password", required = true) String user_password) {
        modelMap.addAttribute("pagetitle", "Login");
        PetAdopter adopter = petAdopterService.login(user_email, user_password);
        if (adopter == null) {
            modelMap.addAttribute("error", true);
            modelMap.addAttribute("message", "Invalid Credentials! Please try again.");
            return "login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("adopterId", adopter.getAdopterId());
        session.setAttribute("userName", adopter.getAdopterName());
        session.setAttribute("user", "adopter");
        modelMap.addAttribute("user", "adopter");
        return "redirect:/adopter/pets";
    }

    @RequestMapping("/pets")
    public String getAnimals(ModelMap modelMap) {
        String[] pet_category = {"Cat", "Dog"};
        String[] pet_gender = {"Male", "Female"};
        List<PetAnimal> petAnimalList = new ArrayList<>();
        petAnimalList = petService.getAllAnimals();

        modelMap.addAttribute("pet_category", pet_category);
        modelMap.addAttribute("pet_gender", pet_gender);
        modelMap.addAttribute("pets", petAnimalList);
        modelMap.addAttribute("message", "Total " + petAnimalList.size() + " records found.");
        return "pet-list";
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

    @RequestMapping("/pets/search")
    public String getAnimalsByCategoryAndGender(ModelMap modelMap, @RequestParam("pet_category") String petCategory, @RequestParam("pet_breed") String petBreed, @RequestParam("pet_gender") String petGender) {
        String[] pet_category = {"Cat", "Dog"};
        String[] pet_gender = {"Male", "Female"};
        List<PetAnimal> pets = null;
        pets = petService.getAnimalsByCategoryAndGender(petCategory, petGender, petBreed);
        modelMap.addAttribute("pet_category", pet_category);
        modelMap.addAttribute("pet_gender", pet_gender);
        modelMap.addAttribute("pets", pets);
        modelMap.addAttribute("message", "Total " + pets.size() + " records found.");
        return "pet-list";
    }

    @RequestMapping("/pets/apply")
    public String apply(@RequestParam("pet_id") int pet_id) throws ParseException {
        PetAnimal petAnimal = petService.getAnimalById(pet_id);
        PetAdopter petAdopter = petAdopterService.getAdopterById(1);

        Application application = new Application();
        application.setPetAnimal(petAnimal);
        application.setPetAdopter(petAdopter);
        application.setApplicationDate(Date.from(Instant.now()));
        applicationService.saveApplication(application);
        return "redirect:/adopter/pets/";
    }

    @RequestMapping("/application")
    public String getApplicationData(ModelMap modelMap) {
        List<Application> applications = new ArrayList<>();
        applications = applicationService.getApplicationByAdopter(1);
        modelMap.addAttribute("applications", applications);
        modelMap.addAttribute("message", "Total " + applications.size() + " records found.");
        return "applications";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap modelMap, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
