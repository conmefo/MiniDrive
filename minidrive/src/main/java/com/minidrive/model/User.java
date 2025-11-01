package com.minidrive.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Data                  
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;                

    @Column(nullable = false, unique = true)
    private String username;      

    @Column(nullable = false)
    private String password;      
}
