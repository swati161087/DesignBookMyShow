package com.example.designbookmyshow.services;

import com.example.designbookmyshow.models.User;
import com.example.designbookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User createUser(String email){
        User user=new User();
        user.setName(email);
        User savedUser=this.userRepository.save(user);
        return savedUser;
    }
}
