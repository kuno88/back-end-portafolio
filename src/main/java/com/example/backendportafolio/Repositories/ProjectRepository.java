package com.example.backendportafolio.Repositories;


import com.example.backendportafolio.Models.ProjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
    Optional<ProjectModel> findByTitle (String title);
    boolean existsByTitle(String title);

}
