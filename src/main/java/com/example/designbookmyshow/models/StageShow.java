package com.example.designbookmyshow.models;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class StageShow extends BaseModel{
   private String groupName;
    private String title;
}
