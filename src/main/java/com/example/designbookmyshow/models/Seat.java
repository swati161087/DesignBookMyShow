package com.example.designbookmyshow.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Seat extends BaseModel{
    private int seatNo;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @OneToMany(mappedBy = "seat")
    private List<ShowSeat> showSeats;
    @ManyToOne
    private Auditorium auditorium;
}
