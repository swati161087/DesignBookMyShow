package com.example.designbookmyshow.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ShowSeatPrice extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    private int price;
}
