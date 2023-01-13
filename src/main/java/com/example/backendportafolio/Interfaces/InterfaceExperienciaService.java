package com.example.backendportafolio.Interfaces;


import com.example.backendportafolio.Models.ExperienceModel;
import java.util.List;

public interface InterfaceExperienciaService {

    public List<ExperienceModel> get();
    public void save(ExperienceModel experiencia);
    public void delete(Long id);
    public  ExperienceModel find(Long id);

}
