package com.nadiritech.repository;

import com.nadiritech.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    // Custom query to show the newest blogs first on your website
    List<Blog> findAllByOrderByCreatedAtDesc();
}