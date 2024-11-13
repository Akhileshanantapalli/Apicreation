package org.example.service;

import org.example.model.User;
import org.example.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Retrieve all users from the database
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Save a new user to the database
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Retrieve a user by ID from the database
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    // Update an existing user in the database
    public User updateUser(Long id, User user) {
        if (userRepository.existsById(id)) {
            user.setId(id); // Ensure the ID remains the same
            return userRepository.save(user);
        }
        return null;
    }

    // Delete a user by ID from the database
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
