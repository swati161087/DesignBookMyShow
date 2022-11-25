package com.example.designbookmyshow.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private int amount;
    @ManyToOne
    private Show show;
    @ManyToOne
    private User user;
    @ManyToMany(mappedBy = "ticket")
    private List<ShowSeat> showSeats=new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
    @OneToMany(mappedBy = "ticket")
    private List<Payment> payment;
}
