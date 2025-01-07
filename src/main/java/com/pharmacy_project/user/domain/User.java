package com.pharmacy_project.user.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Username is required")
    private String username;

    @NotNull(message = "Password is required")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
