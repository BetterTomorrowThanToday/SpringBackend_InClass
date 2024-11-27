package com.example.backend.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserResponseDto {

    private final Long id;             // User ID
    private final String username;     // Username
    private final String email;        // Email
    private final String firstName;    // First Name
    private final String lastName;     // Last Name
    private final String dateOfBirth;  // Date of Birth
    private final String phoneNumber;  // Phone Number
    private final String address;      // Address
    private final boolean isActive;    // Is Active
    private final String role;         // Role (one role only)
}