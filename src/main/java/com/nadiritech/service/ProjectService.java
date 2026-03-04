package com.nadiritech.service;

import com.nadiritech.model.Project;
import com.nadiritech.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Project createProject(Project project) { return repository.save(project); }
    public List<Project> getAllProjects() { return repository.findAll(); }
    public Optional<Project> getProjectById(Long id) { return repository.findById(id); }

    public Project updateProject(Long id, Project data) {
        Project existing = repository.findById(id).orElseThrow();
        existing.setTitle(data.getTitle());
        existing.setClient(data.getClient());
        existing.setOutcome(data.getOutcome());
        existing.setImageUrl(data.getImageUrl());
        return repository.save(existing);
    }

    public void deleteProject(Long id) { repository.deleteById(id); }
}