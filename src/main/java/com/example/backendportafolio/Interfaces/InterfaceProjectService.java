package com.example.backendportafolio.Interfaces;


import com.example.backendportafolio.Models.ProjectModel;

import java.util.List;

public interface InterfaceProjectService {
    public List<ProjectModel> get();
    public void save(ProjectModel project);
    public void delete(Long id);
    public  ProjectModel find(Long id);
}
