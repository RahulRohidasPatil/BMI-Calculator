package com.rahulpatil.bmi.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahulpatil.bmi.models.CatFact;

@Service
public class CatService {
    private final RestTemplate restTemplate;

    public CatService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<CatFact> fetchFactsFromApi() {
        // CatFact[] catFacts =
        // restTemplate.getForObject("https://cat-fact.herokuapp.com/facts",
        // CatFact[].class);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("https://cat-fact.herokuapp.com/facts",
                String.class);
        String jsonResponse = responseEntity.getBody();
        System.out.println("JSON Response: " + jsonResponse);

        ObjectMapper objectMapper = new ObjectMapper();
        List<CatFact> catFactsList = new ArrayList<CatFact>();
        try {
            CatFact[] catFacts = objectMapper.readValue(jsonResponse, CatFact[].class);
            for (CatFact catFact : catFacts) {
                catFactsList.add(catFact);
            }
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return catFactsList;
    }
}
