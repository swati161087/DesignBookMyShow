package com.example.designbookmyshow.controllers;

import com.example.designbookmyshow.models.City;
import com.example.designbookmyshow.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {
    private CityService cityService;
    @Autowired
    CityController(CityService cityService){
        this.cityService=cityService;
    }
    public City addCity(String name){
        return this.cityService.addCity(name);
    }
}
