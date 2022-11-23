package com.example.designbookmyshow.services;

import com.example.designbookmyshow.exceptions.CityNotFoundException;
import com.example.designbookmyshow.models.Address;
import com.example.designbookmyshow.models.City;
import com.example.designbookmyshow.models.Theater;
import com.example.designbookmyshow.repositories.AddressRepository;
import com.example.designbookmyshow.repositories.CityRepository;
import com.example.designbookmyshow.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterService {
    private TheaterRepository theaterRepository;
    private CityRepository cityRepository;
    private AddressRepository addressRepository;
    @Autowired
    TheaterService(TheaterRepository theaterRepository,CityRepository cityRepository,AddressRepository addressRepository){
        this.theaterRepository=theaterRepository;
        this.cityRepository=cityRepository;
        this.addressRepository=addressRepository;
    }
    public Theater addTheater (String name, String  theaterAddress,Long cityId) throws CityNotFoundException {

        Optional<City> city=this.cityRepository.findById(cityId);
        Theater theater=new Theater();
        Address address=new Address();
        address.setCityName("city");
        address.setStreetName(theaterAddress);
        Address savedAddress=this.addressRepository.save(address);
        theater.setAddress(savedAddress);
        if(city.isEmpty()) throw  new CityNotFoundException("city is not found");
        theater.setCity(city.get());
       return  this.theaterRepository.save(theater);
    }
}
