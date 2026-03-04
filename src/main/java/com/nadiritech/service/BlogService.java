package com.nadiritech.service;

import com.nadiritech.model.Blog;
import com.nadiritech.repository.BlogRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private final BlogRepository repository;

    public BlogService(BlogRepository repository) { this.repository = repository; }

    public Blog createBlog(Blog blog) {
        blog.setCreatedAt(LocalDateTime.now());
        return repository.save(blog);
    }

    public List<Blog> getAllBlogs() { return repository.findAllByOrderByCreatedAtDesc(); }
    public Optional<Blog> getBlogById(Long id) { return repository.findById(id); }

    public Blog updateBlog(Long id, Blog data) {
        Blog existing = repository.findById(id).orElseThrow();
        existing.setTitle(data.getTitle());
        existing.setContent(data.getContent());
        existing.setCategory(data.getCategory());
        return repository.save(existing);
    }

    public void deleteBlog(Long id) { repository.deleteById(id); }
}