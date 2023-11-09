package com.rahulpatil.bmi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rahulpatil.bmi.models.BmiModel;
import com.rahulpatil.bmi.services.BmiService;

@Controller
@RequestMapping("/bmi")
public class BmiController {

    @Autowired
    BmiService bmiService;

    @GetMapping("/")
    public String homePage(Model model) {
        List<BmiModel> bmiList = bmiService.getBmiList();

        model.addAttribute("bmiModel", new BmiModel());
        model.addAttribute("bmiList", bmiList);

        return "addBmi";
    }

    /*
     * Author: Rahul Patil
     * Matriculation Number: 1478745
     * Created: 05.11.2023
     */

    @PostMapping("/calculateBMI")
    public String calculateBMI(BmiModel bmiModel, Model model) {
        // Height in meters
        // 0.3048 is the conversion factor to convert feet to meters
        float heightM = bmiModel.getHeight() * 0.3048f;
        bmiModel.setBmi(bmiModel.getWeight() / (heightM * heightM));
        bmiService.addOne(bmiModel);

        List<BmiModel> bmiList = bmiService.getBmiList();
        model.addAttribute("bmiModel", new BmiModel());

        model.addAttribute("bmiModel", bmiModel);
        model.addAttribute("bmiList", bmiList);

        return "addBmi";
    }
}

/*
 * Author: Rahul Patil
 * Matriculation Number: 1478745
 * Created: 05.11.2023
 */