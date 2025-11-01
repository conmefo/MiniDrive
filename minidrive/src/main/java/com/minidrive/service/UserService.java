package com.minidrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minidrive.Repository.UserRepository;
import com.minidrive.dto.request.UserCreationRequest;
import com.minidrive.dto.request.UserUpdateRequest;
import com.minidrive.dto.response.UserResponse;
import com.minidrive.exception.AppException;
import com.minidrive.exception.ErrorCode;
import com.minidrive.mapper.UserMapper;
import com.minidrive.model.User;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    
    public User createUser(UserCreationRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTS);
        }
        
        User user = userMapper.toUser(request);
        
        return userRepository.save(user);
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElse(null);
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).
        orElseThrow(() -> new RuntimeException("User not found")));
    }
}
