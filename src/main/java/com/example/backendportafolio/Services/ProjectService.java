package com.example.backendportafolio.Services;



import com.example.backendportafolio.Interfaces.InterfaceProjectService;
import com.example.backendportafolio.Models.ProjectModel;
import com.example.backendportafolio.Repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional
public class ProjectService implements InterfaceProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<ProjectModel> get() {
        return projectRepository.findAll();
    }

    @Override
    public void save(ProjectModel project) {
        projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectModel find(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public boolean existsById(Long id){
        return projectRepository.existsById(id);
    }
    public boolean existsByTitle(String title){
        return projectRepository.existsByTitle(title);
    }


}
