package com.example.designbookmyshow;

import com.example.designbookmyshow.controllers.CityController;
import com.example.designbookmyshow.controllers.TheaterController;
import com.example.designbookmyshow.controllers.TicketController;
import com.example.designbookmyshow.controllers.UserController;
import com.example.designbookmyshow.dtos.UserRequestDto;
import com.example.designbookmyshow.dtos.UserResponseDto;
import com.example.designbookmyshow.models.Ticket;
import com.example.designbookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DesignBookMyShowApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;
    @Autowired
    private CityController cityController;
    @Autowired
    private TheaterController theaterController;
    @Autowired
    private TicketController ticketController;
    public static void main(String[] args) {
        SpringApplication.run(DesignBookMyShowApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        UserRequestDto userRequestDto=new UserRequestDto();
//        userRequestDto.setEmail("brahma");
//        UserResponseDto userResponseDto= this.userController.createUser(userRequestDto);
//        System.out.println(userResponseDto.getUser().getName());
//        cityController.addCity("Jaipur");
        //theaterController.addTheater("rajmandir","city scheme",(long)1);
        //Ticket ticket =this.ticketController.bookTicket((long)2, List.of((long)1,(long)2),(long)1);
        TicketBookRunner ticketBookRunner1 = new TicketBookRunner(
                this.ticketController,
                2L,
                List.of(1L, 2L, 3L),
                1L
        );

        TicketBookRunner ticketBookRunner2 = new TicketBookRunner(
                this.ticketController,
                2L,
                List.of(3L, 4L),
                1L
        );
        Thread t1 = new Thread(ticketBookRunner1);
        Thread t2 = new Thread(ticketBookRunner2);
        t1.start();
        t2.start();
    }
}
