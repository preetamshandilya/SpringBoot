package com.example.auth.controller;

import com.example.auth.service.UserService;
import com.example.auth.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @Autowired
    private UserService ub;


    @PostMapping("/add")

public @ResponseBody User addUser(@RequestBody User u){
        return ub.addUser(u);


    }
}


