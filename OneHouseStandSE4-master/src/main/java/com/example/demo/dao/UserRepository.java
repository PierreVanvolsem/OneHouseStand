package com.example.demo.dao;

import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    // needed for Spring Security
    public User findByUsername(String username);
}
