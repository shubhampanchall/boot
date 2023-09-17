package com.simplilearn.petadoption.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
    @RequestMapping("/")
    public String startApplication(){
        return "welcome";
    }
}
