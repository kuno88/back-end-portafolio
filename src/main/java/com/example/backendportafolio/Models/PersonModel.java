package com.example.backendportafolio.Models;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter @Setter
@Entity
@Table(name="persons")
public class PersonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne
    @JoinColumn(name="idUser")
    private UserModel user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "person",cascade = CascadeType.ALL)
    private List<ProjectModel> proyectsList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "person",cascade = CascadeType.ALL)
    private List<ExperienceModel> experienceList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "person",cascade = CascadeType.ALL)
    private List<EducationModel> educationList;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "person",cascade = CascadeType.ALL)
    private List<SkillModel> skillList;



    public PersonModel() {
    }

    public PersonModel( String name,  String lastName,  String birth,  String title,  String email,  Integer phone,  String nationality,  String aboutMe,  String bannerUrl,  String profileUrl) {
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
