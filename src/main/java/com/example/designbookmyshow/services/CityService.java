package com.example.designbookmyshow.services;

import com.example.designbookmyshow.models.City;
import com.example.designbookmyshow.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private CityRepository cityRepository;
    @Autowired
    CityService(CityRepository cityRepository){
        this.cityRepository=cityRepository;
    }
    public City addCity(String cityName){
        City city=new City();
        city.setName(cityName);
        city.setPinCode("302017");
        return this.cityRepository.save(city);
    }
}
