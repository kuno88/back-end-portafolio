package com.example.backendportafolio.Controllers;


import com.example.backendportafolio.Dto.DtoProject;
import com.example.backendportafolio.Models.ProjectModel;
import com.example.backendportafolio.Services.ProjectService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/project")
@CrossOrigin(origins = "https://portafolio-f6f99.web.app")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectModel>> list(){
        List<ProjectModel> list = projectService.get();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?>create(@RequestBody DtoProject dtoProject){
        if(StringUtils.isBlank(dtoProject.getTitle()))
            return new ResponseEntity<>(new Mensaje("El titulo es obligatorio"),HttpStatus.BAD_REQUEST);
        if(projectService.existsByTitle(dtoProject.getTitle())) {
            return new ResponseEntity<>(new Mensaje("Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        ProjectModel proyecto = new ProjectModel(
                dtoProject.getDescription(),
                dtoProject.getImgUrl(),
                dtoProject.getTitle(),
                dtoProject.getUrl());
        projectService.save(proyecto);
        return new ResponseEntity<>(new Mensaje("Proyecto agregada"),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>get(@PathVariable("id") Long id){
        if(!projectService.existsById(id))
            return new ResponseEntity<>(new Mensaje("Proyecto no existe"),HttpStatus.NOT_FOUND);
        ProjectModel proje = projectService.find(id);
        return new ResponseEntity<>(proje,HttpStatus.OK);
    }
    @PutMapping("/{id}")
       public ResponseEntity<?>update(@PathVariable("id") Long id, @RequestBody DtoProject dtoProject){
        if(!projectService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(dtoProject.getTitle()))
            return new ResponseEntity<>(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        ProjectModel proyecto = projectService.find(id);
        proyecto.setTitle(dtoProject.getTitle());
        proyecto.setDescription(dtoProject.getDescription());
        proyecto.setImgUrl(dtoProject.getImgUrl());
        proyecto.setUrl(dtoProject.getUrl());
        projectService.save(proyecto);
        return new ResponseEntity<>(new Mensaje("Actualizado"),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable("id") Long id){
        if(!projectService.existsById(id))
            return new ResponseEntity<>(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        projectService.delete(id);
        return new ResponseEntity<>(new Mensaje("Proyecto eliminado"),HttpStatus.OK);
    }
}
