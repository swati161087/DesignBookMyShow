package com.example.designbookmyshow.models;

import javax.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Auditorium extends BaseModel{
    private String name;
    private int capacity;
    @ManyToOne
    private Theater theater;
    @OneToMany(mappedBy = "auditorium")
    private List<Seat> seats;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> features;
    @OneToMany(mappedBy = "auditorium")
    List<Show> shows;
}
