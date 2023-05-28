package com.example.auth.repository;

import com.example.auth.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepoCity extends CrudRepository<City,Integer> {
}
