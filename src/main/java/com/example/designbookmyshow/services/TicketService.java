package com.example.designbookmyshow.services;

import com.example.designbookmyshow.exceptions.SeatNotFoundException;
import com.example.designbookmyshow.models.BookingStatus;
import com.example.designbookmyshow.models.SeatStatus;
import com.example.designbookmyshow.models.ShowSeat;
import com.example.designbookmyshow.models.Ticket;
import com.example.designbookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    private TicketRepository ticketRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private ShowSeatPriceRepository showSeatPriceRepository;
    private Ticket ticket;

    @Autowired
    TicketService(TicketRepository ticketRepository,
                    ShowSeatRepository showSeatRepository,
                  ShowRepository showRepository,
                  UserRepository userRepository,
                  ShowSeatPriceRepository showSeatPriceRepository
                  ){
        this.ticketRepository=ticketRepository;
        this.showSeatRepository=showSeatRepository;
        this.showRepository=showRepository;
        this.userRepository=userRepository;
        this.showSeatPriceRepository=showSeatPriceRepository;
        System.out.println("ticket repository"+ticketRepository.getClass().getName());
    }
    @Transactional(isolation=Isolation.SERIALIZABLE)
        public Ticket bookTicket(Long showId, List<Long> showSeats,Long userId) throws SeatNotFoundException {
        // fetch all the show seats
        List<ShowSeat> showSeatList=this.showSeatRepository.findByIdIn(showSeats);
        // check their status
        for(ShowSeat showSeat:showSeatList){
            if(showSeat.getSeatStatus().equals(SeatStatus.Booked)
                    || showSeat.getSeatStatus().equals(SeatStatus.Locked))
            {
                throw new SeatNotFoundException("Something Wrong");
            }
        }
        // update their status to be locked
        for(ShowSeat showSeat:showSeatList){
            showSeat.setSeatStatus(SeatStatus.Locked);
        }
        List<ShowSeat> showSeatList1=this.showSeatRepository.saveAll(showSeatList);
        Ticket ticket=new Ticket();
        ticket.setAmount((int)200);
        ticket.setBookingStatus(BookingStatus.Pending);
        ticket.setShow(this.showRepository.findById(showId).get());
        ticket.setUser(this.userRepository.findById(userId).get());
        ticket.getShowSeats().addAll(showSeatList1);
       // ticket.setShowSeats(showSeatList1);

        return this.ticketRepository.save(ticket);
        // return the ticket object

    }
}
