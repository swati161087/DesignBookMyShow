package com.example.designbookmyshow.models;

import javax.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Theater extends BaseModel{
    @OneToOne
   private Address address;
    @OneToMany(mappedBy = "theater")
    private List<Auditorium> auditoriams;
    @ManyToOne
    private City city;
}
