package com.eris.gitlabanalyzer.controller;

import com.eris.gitlabanalyzer.model.Project;
import com.eris.gitlabanalyzer.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/project")
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }
    @PostMapping(path = "/analyze")
    public void analyzeProject(
            @RequestBody List<Long> projectIdList,
            @RequestParam(required = true) String serverUrl,
            @RequestParam(required = true) String accessToken){
        projectService.analyzeProjects(projectIdList, serverUrl, accessToken);
    }

    @GetMapping
    public List<Project> getProjects(){
        return projectService.getProjects();
    }
}
