package com.example.forohub.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return "";
    }

    public String getPassword() {
        return "";
    }

    // Getters and Setters
}
