package com.tuition.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tuition.repository.UserRepository;
import com.tuition.model.User;

@Service
public class UserService {
    @Autowired private UserRepository userRepo;

    public User login(String username, String rawPassword) {
        return userRepo.findByUsernameAndPassword(username, rawPassword);
    }

    public List<User> getAllStudents() {
        return userRepo.findByRole("STUDENT");
    }

    public User register(String username, String rawPassword, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(rawPassword);  // no encoding
        user.setRole(role);
        return userRepo.save(user);
    }
}


