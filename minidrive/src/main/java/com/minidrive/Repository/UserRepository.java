package com.minidrive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minidrive.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
