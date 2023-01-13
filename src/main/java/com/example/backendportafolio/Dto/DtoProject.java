package com.example.backendportafolio.Dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DtoProject {
    private String title;
    @Column(length = 2500)
    private String description;

    @Column(length = 2048)
    private String imgUrl;

    @Column(length = 2048)
    private String url;

    public DtoProject() {
    }

    public DtoProject(String title, String description, String imgUrl,String url) {
        this.description = description;
        this.imgUrl = imgUrl;
        this.title = title;
        this.url = url;
    }
}
