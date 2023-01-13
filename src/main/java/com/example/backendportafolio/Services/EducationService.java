package com.example.backendportafolio.Services;

import com.example.backendportafolio.Interfaces.InterfaceEducationService;
import com.example.backendportafolio.Models.EducationModel;
import com.example.backendportafolio.Repositories.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class EducationService implements InterfaceEducationService {
    @Autowired
    EducationRepository educationRepository;

    @Override
    public List<EducationModel> get() {
        return educationRepository.findAll();
    }

    @Override
    public void save(EducationModel educacion) {
        educationRepository.save(educacion);
    }

    @Override
    public void delete(Long id) {
    educationRepository.deleteById(id);
    }

    @Override
    public EducationModel find(Long id) {
        return educationRepository.findById(id).orElse(null);
    }
    public boolean existsById(Long id){
        return educationRepository.existsById(id);
    }
    public boolean existsByName(String instituto){
        return educationRepository.existsByInstitute(instituto);
    }

}
