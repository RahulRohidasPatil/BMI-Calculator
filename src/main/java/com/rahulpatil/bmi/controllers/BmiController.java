package com.rahulpatil.bmi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rahulpatil.bmi.models.BmiModel;
import com.rahulpatil.bmi.services.BmiService;

@Controller
public class BmiController {

    @Autowired
    BmiService bmiService;

    @GetMapping("/")
    public String testController(Model model) {
        List<BmiModel> bmiList = bmiService.getBmiList();

        model.addAttribute("bmiList", bmiList);

        return "bmiList";
    }
}
