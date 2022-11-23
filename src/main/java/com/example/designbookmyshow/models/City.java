package com.example.designbookmyshow.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;
    private String pinCode;
    @OneToMany(mappedBy = "city")
    private List<Theater> theaters;
}
