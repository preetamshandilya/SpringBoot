package com.example.auth.repository;

import com.example.auth.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoState extends CrudRepository<State,Integer> {
}
