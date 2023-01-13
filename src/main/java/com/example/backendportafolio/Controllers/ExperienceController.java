package com.example.backendportafolio.Controllers;


import com.example.backendportafolio.Dto.DtoExperience;
import com.example.backendportafolio.Models.ExperienceModel;
import com.example.backendportafolio.Services.ExperienceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @GetMapping("/all")
    public ResponseEntity<List< ExperienceModel>> list(){
        List<ExperienceModel> list = experienceService.get();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoExperience dtoExperience){
        if(StringUtils.isBlank(dtoExperience.getCompanyName()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if(experienceService.existsByName(dtoExperience.getCompanyName())) {
            return new ResponseEntity<>(new Mensaje("Ecperiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        ExperienceModel experiencia = new ExperienceModel(dtoExperience.getStart(),
                dtoExperience.getEnd(),
                dtoExperience.getCompanyName(),
                dtoExperience.getDescription(),
                dtoExperience.getImgUrl());
        experienceService.save(experiencia);
        return new ResponseEntity<>(new Mensaje("Experiencia agregada"),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable("id") Long id, @RequestBody DtoExperience dtoExperience){
        if(!experienceService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La experiencia no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoExperience.getCompanyName()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        ExperienceModel experiencia = experienceService.find(id);
        experiencia.setCompanyName(dtoExperience.getCompanyName());
        experiencia.setDescription(dtoExperience.getDescription());
        experiencia.setStart(dtoExperience.getStart());
        experiencia.setEnd(dtoExperience.getEnd());
        experiencia.setImgUrl(dtoExperience.getImgUrl());
        experienceService.save(experiencia);
        return new ResponseEntity<>(new Mensaje("Actualizado"),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id){
        if(!experienceService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La experiencia no existe"), HttpStatus.BAD_REQUEST);
        experienceService.delete(id);
        return new ResponseEntity<>(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>get(@PathVariable("id") Long id){
        if(!experienceService.existsById(id))
            return new ResponseEntity<>(new Mensaje("Experiencia no existe"),HttpStatus.NOT_FOUND);
        ExperienceModel expe = experienceService.find(id);
        return new ResponseEntity<>(expe,HttpStatus.OK);
    }

}
