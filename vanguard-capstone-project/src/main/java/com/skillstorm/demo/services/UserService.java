package com.skillstorm.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.demo.models.User;
import com.skillstorm.demo.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null ||
                userRepository.findByEmail(user.getEmail()) != null) {
            return false; // Username or email already exists
        }

        // Perform any additional checks or validation here before saving the user

        userRepository.save(user);
        return true;
    }

    // Add other methods as needed, e.g., getUserById, updateUser, deleteUser, etc.
}