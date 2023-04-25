package com.example.auth.repository;

import com.example.auth.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface RepoCountry extends CrudRepository<Country,Integer> {
}
