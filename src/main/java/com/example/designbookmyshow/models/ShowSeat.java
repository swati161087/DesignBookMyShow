package com.example.designbookmyshow.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
    @ManyToMany
    private List<Ticket> ticket;

}
