package com.example.designbookmyshow;

import com.example.designbookmyshow.controllers.TicketController;

import java.util.List;

public class TicketBookRunner implements Runnable{
    private TicketController ticketController;
    private Long showId;
    private List<Long> showSeatId;
    private Long userId;
    public TicketBookRunner(TicketController ticketController,
                            Long showId,
                            List<Long> showSeatId,
                            Long userId) {
        this.ticketController = ticketController;
        this.showId = showId;
        this.showSeatId = showSeatId;
        this.userId = userId;
    }
    @Override
    public void run() {
        try {
            this.ticketController.bookTicket(
                    showId,
                    showSeatId,
                    userId
            );
        } catch (Exception exception) {
            System.out.println("EXCEPTIOOOOOOOOONNNN: " + exception.getMessage());
        }
    }
}
