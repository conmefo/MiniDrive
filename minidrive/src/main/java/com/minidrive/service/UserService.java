package com.minidrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minidrive.Repository.UserRepository;
import com.minidrive.dtorequest.UserCreationRequest;
import com.minidrive.dtorequest.UserUpdateRequest;
import com.minidrive.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public User createUser(UserCreationRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    public User updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElse(null);
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
