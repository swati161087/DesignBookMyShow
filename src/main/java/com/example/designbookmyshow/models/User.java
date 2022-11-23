package com.example.designbookmyshow.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
@Table(name="users")
public class User extends BaseModel{
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Ticket> tickets;
}
