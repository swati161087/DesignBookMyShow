package com.example.designbookmyshow.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Address extends BaseModel{
    private String cityName;
    private String streetName;
    private String pinCode;
}
