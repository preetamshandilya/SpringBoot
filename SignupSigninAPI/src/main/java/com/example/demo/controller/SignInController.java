package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SignInController {
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SignInController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signin")
    public @ResponseBody String  signIn(@RequestBody User user){
        User u = userRepository.findByUsername(user.getUsername());

        if (u == null) {
            throw new IllegalArgumentException("Invalid username");
        }

        if (!passwordEncoder.matches(user.getPassword(), u.getPassword())) {
           throw new IllegalArgumentException("Invalid password");
       }

        return "Successfully logged in";
    }



        }
