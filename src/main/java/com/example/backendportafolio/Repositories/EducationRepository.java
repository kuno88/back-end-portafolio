package com.example.backendportafolio.Repositories;

import com.example.backendportafolio.Models.EducationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationRepository extends JpaRepository<EducationModel, Long> {

    public boolean existsByInstitute(String institute);
}
