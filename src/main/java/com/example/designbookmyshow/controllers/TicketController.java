package com.example.designbookmyshow.controllers;

import com.example.designbookmyshow.models.ShowSeat;
import com.example.designbookmyshow.models.Ticket;
import com.example.designbookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketController {
    private TicketService ticketService;
    @Autowired
    TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }
    public Ticket bookTicket(Long showId, List<Long> showSeats,Long userId) throws Exception{

    return this.ticketService.bookTicket( showId,  showSeats, userId);

    }
}
