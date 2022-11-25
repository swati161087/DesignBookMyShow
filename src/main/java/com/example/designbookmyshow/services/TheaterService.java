package com.example.designbookmyshow.services;

import com.example.designbookmyshow.exceptions.CityNotFoundException;
import com.example.designbookmyshow.models.*;
import com.example.designbookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TheaterService {
    private TheaterRepository theaterRepository;
    private CityRepository cityRepository;
    private AddressRepository addressRepository;
    private AuditoriumRepository auditoriumRepository;
    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    @Autowired
    TheaterService(TheaterRepository theaterRepository,CityRepository cityRepository,
                   AddressRepository addressRepository,
                   AuditoriumRepository auditoriumRepository,
                   SeatRepository seatRepository,
                   ShowSeatRepository showSeatRepository
                   ){
        this.theaterRepository=theaterRepository;
        this.cityRepository=cityRepository;
        this.addressRepository=addressRepository;
        this.auditoriumRepository=auditoriumRepository;
        this.seatRepository=seatRepository;
        this.showSeatRepository=showSeatRepository;
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
        theater.setName("RajMandir");
        Theater theaterCreated=  this.theaterRepository.save(theater);
        List<Auditorium> auditoriums=new ArrayList<>();
        for(int i=0;i<2;i++)
        {
            Auditorium temp=new Auditorium();
            temp.setName("RajMandir"+i);
            temp.setTheater(theaterCreated);
            Auditorium savedAuditorium=this.auditoriumRepository.save(temp);
            List<Seat> seats=new ArrayList<>();
            for(int j=1;j<10;j++){
                ShowSeat showSeat=new ShowSeat();
                Seat seat=new Seat();
                seat.setSeatNo(j+"");
                seat.setSeatType(SeatType.Middle);
                seat.setAuditorium(savedAuditorium);
                seats.add(seat);
            }
            List<Seat> savedSeats=this.seatRepository.saveAll(seats);
        }


        return theaterCreated;
    }
    public void addSeats(
            Long auditoriumId,
            Map<SeatType, Integer> seatCount
    ) {
        Auditorium auditorium = auditoriumRepository.findById(auditoriumId).get();

        List<Seat> seats = new ArrayList<>();

        for (Map.Entry<SeatType, Integer> entry : seatCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); ++i) {
                Seat seat = new Seat();
                seat.setSeatType(entry.getKey());
                // VIP1 VIP2 VIP3
                // PREMIUM1 PREMIUM2 PREMIUM3
                seat.setSeatNo(entry.getKey().toString() + Integer.toString(i + 1));
                seats.add(seat);
            }
        }

        List<Seat> savedSeats = seatRepository.saveAll(seats);

        auditorium.setSeats(savedSeats);

        auditoriumRepository.save(auditorium);
    }
}
