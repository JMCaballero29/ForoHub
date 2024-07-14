package com.example.forohub.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String message;

    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne
    private Topic topic;

    @NotBlank
    private String author;

    public Object getMessage() {
        return null;
    }

    public Object getAuthor() {
        return null;
    }

    public void setMessage(Object message) {
    }

    public void setAuthor(Object author) {
    }

    // Getters and Setters
}
