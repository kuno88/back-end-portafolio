package com.example.backendportafolio.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class DtoSkill {

    private String name;
    private String value;
    @Column(length = 2048)
    private String imgUrl;

    private String type;

    public DtoSkill() {
    }

    public DtoSkill(String name, String value, String imgUrl, String type) {
        this.name = name;
        this.value = value;
        this.imgUrl = imgUrl;
        this.type = type;
    }
}
