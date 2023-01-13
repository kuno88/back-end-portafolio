package com.example.backendportafolio.Models;

import jakarta.persistence.*;
import lombok.Getter;

import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="experience")
public class ExperienceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String start;

    private String end;

    @Column(length = 2500)
    private String description;

    private String companyName;

    @Column(length = 2048)
    private String imgUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPerson")
    private PersonModel person;

    public ExperienceModel() {
    }

    public ExperienceModel( String start, String end,  String description, String companyName, String imgUrl) {
        this.start = start;
        this.end = end;
        this.description = description;
        this.companyName = companyName;
        this.imgUrl = imgUrl;
    }
}
