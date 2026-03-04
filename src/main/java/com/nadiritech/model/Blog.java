package com.nadiritech.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

    @Entity
    @Data
    public class Blog {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String title;

        @Column(columnDefinition = "TEXT") // Allows for long blog content
        private String content;

        private String author;
        private LocalDateTime createdAt = LocalDateTime.now();
        private String category; // e.g., "AI", "Cloud", "Business"
    }

