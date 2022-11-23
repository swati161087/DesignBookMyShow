package com.example.designbookmyshow.controllers;

import com.example.designbookmyshow.dtos.UserRequestDto;
import com.example.designbookmyshow.dtos.UserResponseDto;
import com.example.designbookmyshow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.designbookmyshow.services.UserService;
@Controller
public class UserController {
    private UserService userService;
    @Autowired
    UserController(UserService userService){
        System.out.println("User service is being called");
        this.userService=userService;
    }
    public UserResponseDto createUser(UserRequestDto userRequestDto){
        String email=userRequestDto.getEmail();
        User user=this.userService.createUser(email);
        UserResponseDto userResponseDto=new UserResponseDto();
        userResponseDto.setUser(user);
        return userResponseDto;
    }
}
