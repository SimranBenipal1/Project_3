package com.skillstorm.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.demo.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
