package com.example.backendportafolio.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter @Setter
@Entity
@Table(name="user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String password;


    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private PersonModel person;

    public UserModel() {
    }

    public UserModel(String nombre,String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }
}
