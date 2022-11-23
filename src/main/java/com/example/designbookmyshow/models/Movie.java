package com.example.designbookmyshow.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

@Entity
public class Movie extends BaseModel{
    private String name;
    private int rating;
    @Enumerated(EnumType.STRING)
    private Genera genera;
    @ManyToMany
    private List<Actor> actors;
}
