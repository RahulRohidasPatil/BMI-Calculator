package com.rahulpatil.bmi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rahulpatil.bmi.models.BmiModel;
import com.rahulpatil.bmi.services.BmiService;

@Controller
public class BmiController {

    @Autowired
    BmiService bmiService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("bmiModel", new BmiModel());
        return "addBmi";
    }

    @GetMapping("/bmi-list")
    public String showBmiList(Model model) {
        List<BmiModel> bmiList = bmiService.getBmiList();

        model.addAttribute("bmiList", bmiList);

        return "bmiList";
    }

    @PostMapping("/calculateBMI")
    public String calculateBMI(BmiModel bmiModel, Model model) {
        bmiModel.setBmi(bmiModel.getWeight() / (bmiModel.getHeight() * bmiModel.getHeight()));

        bmiService.addOne(bmiModel);

        model.addAttribute("bmiModel", bmiModel);
        return "bmiAdded";
    }
}
