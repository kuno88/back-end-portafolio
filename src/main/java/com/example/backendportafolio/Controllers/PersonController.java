package com.example.backendportafolio.Controllers;


import com.example.backendportafolio.Dto.DtoPerson;
import com.example.backendportafolio.Models.PersonModel;
import com.example.backendportafolio.Services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/person")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<PersonModel>> list(){
        List<PersonModel> list = personService.get();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoPerson dtoPerson){
        PersonModel persona = new PersonModel(
                dtoPerson.getName(),
                dtoPerson.getLastName(),
                dtoPerson.getBirth(),
                dtoPerson.getTitle(),
                dtoPerson.getEmail(),
                dtoPerson.getPhone(),
                dtoPerson.getNationality(),
                dtoPerson.getAboutMe(),
                dtoPerson.getBannerUrl(),
                dtoPerson.getProfileUrl());
        personService.save(persona);
        return new ResponseEntity<>(new Mensaje("Persona agregada"), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public PersonModel find(@PathVariable Long id){
        return personService.find(id);
    }


    @PutMapping("/{id}")
public ResponseEntity<?>update(@PathVariable ("id") Long id,@RequestBody DtoPerson dtoPerson){
        if(!personService.existsById(id))
            return new ResponseEntity<>(new Mensaje("Persona no encontrada"),HttpStatus.BAD_REQUEST);
        PersonModel persona = personService.find(id);
        persona.setName(dtoPerson.getName());
        persona.setLastName(dtoPerson.getLastName());
        persona.setBirth(dtoPerson.getBirth());
        persona.setTitle(dtoPerson.getTitle());
        persona.setEmail(dtoPerson.getEmail());
        persona.setPhone(dtoPerson.getPhone());
        persona.setNationality(dtoPerson.getNationality());
        persona.setAboutMe(dtoPerson.getAboutMe());
        persona.setBannerUrl(dtoPerson.getBannerUrl());
        persona.setProfileUrl(dtoPerson.getProfileUrl());
        personService.save(persona);
        return new ResponseEntity<>(new Mensaje("Actualizado"),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        personService.delete(id);
        return "Eliminado correctamente";
    }

}
