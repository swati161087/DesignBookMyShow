package com.example.designbookmyshow.models;

import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class StandUpComedy extends BaseModel{
    private String artistName;
    private String title;
}
