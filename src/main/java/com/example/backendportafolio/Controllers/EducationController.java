package com.example.backendportafolio.Controllers;


import com.example.backendportafolio.Dto.DtoEducation;
import com.example.backendportafolio.Models.EducationModel;
import com.example.backendportafolio.Services.EducationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/education")
@CrossOrigin("**")
public class EducationController {

    @Autowired
    EducationService educationService;


    @GetMapping("/all")
    public ResponseEntity<List<EducationModel>> list(){
        List<EducationModel> list = educationService.get();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoEducation dtoEducation){
        if(StringUtils.isBlank(dtoEducation.getInstitute()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if (educationService.existsByName(dtoEducation.getInstitute()))
            return new ResponseEntity<>(new Mensaje("Educacion ya existe"),HttpStatus.BAD_REQUEST);
        EducationModel educacion = new EducationModel(
                dtoEducation.getTitle(),
                dtoEducation.getInstitute(),
                dtoEducation.getStart(),
                dtoEducation.getEnd(),
                dtoEducation.getLogoUrl());
        educationService.save(educacion);
        return new ResponseEntity<>(new Mensaje("Educacion agregada"),HttpStatus.OK);
    }

    @GetMapping("/{id}")
     public ResponseEntity<?>get(@PathVariable("id") Long id){
        if(!educationService.existsById(id))
            return new ResponseEntity<>(new Mensaje("Educacion no existe"),HttpStatus.NOT_FOUND);
        EducationModel edu = educationService.find(id);
        return new ResponseEntity<>(edu,HttpStatus.OK);
    }

    @PutMapping("/{id}")
     public ResponseEntity<?>update(@PathVariable("id") Long id, @RequestBody DtoEducation dtoEducation){
        if(!educationService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La educacion no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoEducation.getInstitute())) {
            return new ResponseEntity<>(new Mensaje("El instituto es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        EducationModel educacion = educationService.find(id);
        educacion.setInstitute(dtoEducation.getInstitute());
        educacion.setTitle(dtoEducation.getTitle());
        educacion.setStart(dtoEducation.getStart());
        educacion.setEnd(dtoEducation.getEnd());
        educacion.setLogoUrl(dtoEducation.getLogoUrl());
        educationService.save(educacion);
        return new ResponseEntity<>(new Mensaje("Actualizado"),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?>delete(@PathVariable("id") Long id){
       /* if(!educationService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La educacion no existe"), HttpStatus.BAD_REQUEST);*/
        educationService.delete(id);
        return new ResponseEntity<>(new Mensaje("Educacion eliminada"),HttpStatus.OK);
    }

}
