package com.example.demo.controller;


import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SignUpController {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public SignUpController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }




    @PostMapping("/signup")
    public @ResponseBody User signUp(@RequestBody User user){

        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username already taken");
        }
        BCryptPasswordEncoder bCrypt=new BCryptPasswordEncoder();
        String encodedPassword = bCrypt.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);



        return user;
    }
}
