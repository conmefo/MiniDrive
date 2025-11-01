package com.minidrive.dtorequest;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserCreationRequest {
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
    private String username;      

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;  
}
