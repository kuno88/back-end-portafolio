package com.example.backendportafolio.Controllers;

import com.example.backendportafolio.Dto.DtoSkill;
import com.example.backendportafolio.Models.SkillModel;
import com.example.backendportafolio.Services.SkillService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin()
public class SkillController {
    @Autowired
    SkillService skillService;

    @GetMapping("/all")
    public ResponseEntity<List<SkillModel>> list(){
        List<SkillModel> list = skillService.get();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoSkill dtoSkill){
        if(StringUtils.isBlank(dtoSkill.getName()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
        if(skillService.existByName(dtoSkill.getName())) {
            return new ResponseEntity<>(new Mensaje("Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        SkillModel skill = new SkillModel(
                dtoSkill.getName(),
                dtoSkill.getValue(),
                dtoSkill.getImgUrl(),
                dtoSkill.getType());
        skillService.save(skill);
        return new ResponseEntity<>(new Mensaje("Skill agregada"),HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable("id") Long id, @RequestBody DtoSkill dtoSkill){
        if(!skillService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El skill no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoSkill.getName()))
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        SkillModel skill = skillService.find(id);
        skill.setName(dtoSkill.getName());
        skill.setValue(dtoSkill.getValue());
        skill.setImgUrl(dtoSkill.getImgUrl());
        skill.setType(dtoSkill.getType());
        skillService.save(skill);
        return new ResponseEntity<>(new Mensaje("Actualizado"),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id){
        if(!skillService.existsById(id))
            return new ResponseEntity<>(new Mensaje("La skill no existe"), HttpStatus.NOT_FOUND);
        skillService.delete(id);
        return new ResponseEntity<>(new Mensaje("Skill eliminada"),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>get(@PathVariable("id") Long id){
        if(!skillService.existsById(id))
            return new ResponseEntity<>(new Mensaje("Skill no existe"),HttpStatus.NOT_FOUND);
        SkillModel skill = skillService.find(id);
        return new ResponseEntity<>(skill,HttpStatus.OK);
    }
    @GetMapping("/type")
    public ResponseEntity<List<SkillModel>> getType(String type){
        List<SkillModel> listType = skillService.getSkillByType(type);
        return new ResponseEntity<>(listType, HttpStatus.OK);
    }

}
