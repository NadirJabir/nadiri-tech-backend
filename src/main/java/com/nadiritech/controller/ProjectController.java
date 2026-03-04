package com.nadiritech.controller;

import com.nadiritech.model.Project;
import com.nadiritech.service.ProjectService; // Point to the new service
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {
    private final ProjectService service;
    public ProjectController(ProjectService service) { this.service = service; }

    @PostMapping // CREATE
    public Project create(@RequestBody Project p) { return service.createProject(p); }

    @GetMapping // GET ALL
    public List<Project> list() { return service.getAllProjects(); }

    @PutMapping("/{id}") // UPDATE
    public ResponseEntity<Project> update(@PathVariable Long id, @RequestBody Project p) {
        return ResponseEntity.ok(service.updateProject(id, p));
    }

    @DeleteMapping("/{id}") // DELETE
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}