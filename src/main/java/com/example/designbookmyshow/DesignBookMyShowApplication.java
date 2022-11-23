package com.example.designbookmyshow;

import com.example.designbookmyshow.controllers.CityController;
import com.example.designbookmyshow.controllers.TheaterController;
import com.example.designbookmyshow.controllers.UserController;
import com.example.designbookmyshow.dtos.UserRequestDto;
import com.example.designbookmyshow.dtos.UserResponseDto;
import com.example.designbookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesignBookMyShowApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;
    @Autowired
    private CityController cityController;
    @Autowired
    private TheaterController theaterController;
    public static void main(String[] args) {
        SpringApplication.run(DesignBookMyShowApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        UserRequestDto userRequestDto=new UserRequestDto();
        userRequestDto.setEmail("brahma");
        UserResponseDto userResponseDto= this.userController.createUser(userRequestDto);
        System.out.println(userResponseDto.getUser().getName());
        cityController.addCity("Jaipur");
        theaterController.addTheater("rajmandir","city scheme",(long)1);
    }
}
