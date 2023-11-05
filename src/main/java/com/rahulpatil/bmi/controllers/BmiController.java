package com.rahulpatil.bmi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rahulpatil.bmi.services.BmiService;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BmiController {

    @Autowired
    BmiService bmiService;

    @GetMapping("/")
    @ResponseBody
    public String testController() {
        return bmiService.getBmiList().toString();
    }
}
