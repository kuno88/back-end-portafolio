package com.example.backendportafolio.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;



@Getter@ Setter
public class DtoPerson {
    private String name;

    private String lastName;

    private String birth;

    private String title;

    private String email;

    private Integer phone;

    private String nationality;

    @Column(length = 2500)
    private String aboutMe;

    @Column(length = 2048)
    private String bannerUrl;

    @Column(length = 2048)
    private String profileUrl;

    public DtoPerson() {
    }

    public DtoPerson(String name, String lastName, String birth, String title, String email, Integer phone, String nationality, String aboutMe, String bannerUrl, String profileUrl) {
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.title = title;
        this.email = email;
        this.phone = phone;
        this.nationality = nationality;
        this.aboutMe = aboutMe;
        this.bannerUrl = bannerUrl;
        this.profileUrl = profileUrl;
    }
}
