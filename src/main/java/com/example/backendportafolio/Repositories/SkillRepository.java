package com.example.backendportafolio.Repositories;

import com.example.backendportafolio.Models.SkillModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SkillRepository extends JpaRepository<SkillModel, Long> {
    public List<SkillModel>getSkillModelByType(String type);
    public boolean existsByName(String name);

}
