package com.example.backend.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    private Long id;  // User의 id와 일치

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

//    @Column(name = "first_name", length = 50)
    private String firstName;

//    @Column(name = "last_name", length = 50)
    private String lastName;

//    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String address;

}