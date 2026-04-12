package com.elearning_system.service;

import com.elearning_system.entity.User;
import com.elearning_system.repository.UserRepository;
import com.elearning_system.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    // Register
    public User register(User user) {
        return repo.save(user);
    }

    // Login validation
    public User login(String email, String password) {

        Optional<User> userOptional = repo.findByEmail(email);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        User user = userOptional.get();

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
   

    public String loginAndGenerateToken(String email, String password) {
        User user = login(email, password);
        return jwtUtil.generateToken(user.getEmail());
    }
}