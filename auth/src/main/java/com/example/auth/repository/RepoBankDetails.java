package com.example.auth.repository;


import com.example.auth.model.BankDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RepoBankDetails extends CrudRepository<BankDetails,Integer> {
}

