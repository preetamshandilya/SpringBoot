package com.example.auth.repository;

import com.example.auth.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoUser extends CrudRepository<User,Integer> {
}
