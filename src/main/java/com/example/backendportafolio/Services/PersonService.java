package com.example.backendportafolio.Services;

import com.example.backendportafolio.Interfaces.InterfacePersonService;
import com.example.backendportafolio.Models.PersonModel;
import com.example.backendportafolio.Repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
@Transactional
public class PersonService implements InterfacePersonService {
    @Autowired
    PersonRepository personaRepositorio;
    @Override
    public List<PersonModel> get() {
        return personaRepositorio.findAll();
    }

    @Override
    public void save(PersonModel persona) {
        personaRepositorio.save(persona);
    }

    @Override
    public void delete(Long id) {
        personaRepositorio.deleteById(id);
    }

    @Override
    public PersonModel find(Long id) {
        return personaRepositorio.findById(id).orElse(null);
    }
    public boolean existsById(Long id){
        return personaRepositorio.existsById(id);
    }


}
