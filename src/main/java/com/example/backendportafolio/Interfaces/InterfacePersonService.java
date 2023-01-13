package com.example.backendportafolio.Interfaces;


import com.example.backendportafolio.Models.PersonModel;

import java.util.List;

public interface InterfacePersonService {
    public List<PersonModel> get();
    public void save(PersonModel persona);
    public void delete(Long id);
    public PersonModel find(Long id);

}
