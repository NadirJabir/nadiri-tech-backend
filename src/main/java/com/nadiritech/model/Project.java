package com.nadiritech.model;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // If using Lombok, otherwise generate Getters/Setters
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String client;
    private String outcome;
    private String imageUrl;
}