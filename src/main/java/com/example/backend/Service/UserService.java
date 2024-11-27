package com.example.backend.Service;

import com.example.backend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.Dto.UserResponseDto;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDto(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getUserDetails().getFirstName(),
                        user.getUserDetails().getLastName(),
                        user.getUserDetails().getDateOfBirth().toString(),
                        user.getUserDetails().getPhoneNumber(),
                        user.getUserDetails().getAddress(),
                        user.isActive(),
                        user.getUserRoles().getRole().name()
                ))
                .collect(Collectors.toList());
    }
}