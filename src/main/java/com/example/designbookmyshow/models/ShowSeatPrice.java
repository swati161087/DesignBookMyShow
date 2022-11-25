package com.example.designbookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
@Getter
@Setter
@Entity
public class ShowSeatPrice extends BaseModel{
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private int price;
}
