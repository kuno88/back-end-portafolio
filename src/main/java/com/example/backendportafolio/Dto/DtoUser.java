package com.example.backendportafolio.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoUser {

    private String nombre;
    private String email;
    private String password;

    public DtoUser() {
    }

    public DtoUser(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
}
