package com.rahulpatil.bmi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahulpatil.bmi.models.CatFact;
import com.rahulpatil.bmi.services.CatService;

@RestController
@RequestMapping("/cat")
public class CatController {

    @Autowired
    CatService catService;

    @GetMapping
    public List<CatFact> getFacts() {
        return this.catService.fetchFactsFromApi();
    }
}
