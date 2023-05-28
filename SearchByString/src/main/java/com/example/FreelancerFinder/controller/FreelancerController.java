package com.example.FreelancerFinder.controller;

import com.example.FreelancerFinder.model.Freelancer;
import com.example.FreelancerFinder.repository.RepoFreelancer;
import com.example.FreelancerFinder.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class FreelancerController {
    @Autowired
    private FreelancerService fs;



    @PostMapping("/add")
    public @ResponseBody Freelancer addFreelancer(@RequestBody Freelancer freelancer){
        return fs.add(freelancer);
    }

    @GetMapping("/fetchString")
    public @ResponseBody List<Freelancer> fetchByString(@RequestParam(value = "keyword") String keyword){
        return fs.showAll(keyword);
    }








}
