package com.example.backendportafolio.Interfaces;

import com.example.backendportafolio.Models.EducationModel;

import java.util.List;

public interface InterfaceEducationService {

    public List<EducationModel> get();
    public void save(EducationModel educacion);
    public void delete(Long id);
    public  EducationModel find(Long id);
}
