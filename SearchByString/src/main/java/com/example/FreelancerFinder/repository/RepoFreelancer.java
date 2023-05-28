package com.example.FreelancerFinder.repository;

import com.example.FreelancerFinder.model.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RepoFreelancer extends JpaRepository<Freelancer,Integer> {

    @Query(value = "SELECT * FROM freelancers AS f WHERE LOWER(f.tech_stack) LIKE %:keyword%",nativeQuery = true)
    public List<Freelancer> findByTechStackContainingAndFreelancer(@Param("keyword") String keyword);
}
