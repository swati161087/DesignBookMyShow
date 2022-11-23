package com.example.designbookmyshow.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Payment extends BaseModel {
    private PaymentStatus paymentStatus;
    private int referenceId;
    private int amount;
    @ManyToOne
    private Ticket ticket;
}
