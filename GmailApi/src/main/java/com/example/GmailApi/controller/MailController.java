package com.example.GmailApi.controller;

import com.example.GmailApi.service.GmailService;
import com.example.GmailApi.service.IGmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class MailController {
    @Autowired
    public IGmailService gmailService;


    @PostMapping("/auth")
    public @ResponseBody String authenticate() throws GeneralSecurityException, IOException {
        gmailService.getAuth();
        return "Success";


    }

}
