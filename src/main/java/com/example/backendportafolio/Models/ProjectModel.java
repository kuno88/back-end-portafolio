package com.example.backendportafolio.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="proyects")
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 2500)
    private String description;

    @Column(length = 2048)
    private String imgUrl;

    private String title;

    @Column(length = 2048)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPerson")
    private PersonModel person;


    public ProjectModel() {
    }

    public ProjectModel( String description, String imgUrl, String title, String url) {
        this.description = description;
        this.imgUrl = imgUrl;
        this.title = title;
        this.url = url;
    }
}
