package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Boolean create(String name,String password) {
        var user = User.builder()
                .name(name)
                .password(password)
                .build();
        userRepository.save(user);
        return true;
    }
}
