package com.example.FreelancerFinder.service;

import com.example.FreelancerFinder.model.Freelancer;
import com.example.FreelancerFinder.repository.RepoFreelancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreelancerService {
    @Autowired
    private RepoFreelancer repoFreelancer;

    public Freelancer add(Freelancer f){
        repoFreelancer.save(f);
        return f;
    }


    public List<Freelancer> showAll(String keyword){
        if(keyword!=null){
            return repoFreelancer.findByTechStackContainingAndFreelancer(keyword);
        }
        return repoFreelancer.findAll();
    }





}
