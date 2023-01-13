package com.example.backendportafolio.Controllers;


import com.example.backendportafolio.Dto.DtoUser;
import com.example.backendportafolio.Models.UserModel;
import com.example.backendportafolio.Services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "https://portafolio-f6f99.web.app")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoUser dtoUser){
        if(StringUtils.isBlank(dtoUser.getEmail()))
            return new ResponseEntity<>(new Mensaje("El email es obligatorio"), HttpStatus.BAD_REQUEST);
        if(userService.existsByEmail(dtoUser.getEmail())) {
            return new ResponseEntity<>(new Mensaje("Correo ya Utilizado"), HttpStatus.BAD_REQUEST);
        }
        UserModel usuario = new UserModel(
                dtoUser.getNombre(),
                dtoUser.getEmail(),
                dtoUser.getPassword());
                userService.save(usuario);
        return new ResponseEntity<>(new Mensaje("Usuario creado"),HttpStatus.OK);
    }


}
