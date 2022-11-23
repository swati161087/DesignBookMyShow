package com.example.designbookmyshow.controllers;

import com.example.designbookmyshow.exceptions.CityNotFoundException;
import com.example.designbookmyshow.models.Theater;
import com.example.designbookmyshow.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TheaterController {
    private TheaterService theaterService;
    @Autowired
    TheaterController(TheaterService theaterService){
        this.theaterService=theaterService;
    }
    public Theater addTheater(String name,String address, Long cityId){
        try{
            return this.theaterService.addTheater(name,address,cityId);
        }
        catch (CityNotFoundException e){
            System.out.println("something went wrong");
        }

        return null;
    }
}
