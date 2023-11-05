package com.rahulpatil.bmi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BmiController {
    @GetMapping("/")
    @ResponseBody
    public String testController(){
        return "Test";
    }
}
