package com.nadiritech.controller;

import com.nadiritech.model.Blog;
import com.nadiritech.service.BlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "*")
public class BlogController {
    private final BlogService service;
    public BlogController(BlogService service) { this.service = service; }

    @PostMapping // CREATE
    public Blog create(@RequestBody Blog b) { return service.createBlog(b); }

    @GetMapping // GET ALL
    public List<Blog> list() { return service.getAllBlogs(); }

    @PutMapping("/{id}") // UPDATE
    public ResponseEntity<Blog> update(@PathVariable Long id, @RequestBody Blog b) {
        return ResponseEntity.ok(service.updateBlog(id, b));
    }

    @DeleteMapping("/{id}") // DELETE
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteBlog(id);
        return ResponseEntity.noContent().build();
    }
}