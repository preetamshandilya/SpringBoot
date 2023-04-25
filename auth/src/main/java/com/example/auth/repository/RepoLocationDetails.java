package com.example.auth.repository;


import com.example.auth.model.LocationDetails;
import org.springframework.data.repository.CrudRepository;

public interface RepoLocationDetails extends CrudRepository<LocationDetails,Integer> {
}
