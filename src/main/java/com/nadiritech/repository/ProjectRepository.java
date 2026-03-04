package com.nadiritech.repository;

import com.nadiritech.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Basic CRUD methods like save(), findAll(), and findById() are included by default!
}