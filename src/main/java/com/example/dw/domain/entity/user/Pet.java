package com.example.dw.domain.entity.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.Builder.Default;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "pet")
public class Pet {
    @Id @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    private String birthDate;
    private String name;
    private Long weight;

//    @Enumerated(EnumType.STRING)
//    @ColumnDefault("'N'")
    private String petGender;

//    @ColumnDefault("y")
    @Default
    private String neutering ="N";


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;

    @OneToMany(mappedBy = "pet" ,fetch = FetchType.LAZY)
    private List<PetImg> petImg;




    private String petCategory;

    @Builder
    public Pet(Long id, String birthDate, String name, Long weight, String petGender, String neutering, Users users, List<PetImg> petImg, String petCategory) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.weight = weight;
        this.petGender = petGender;
        this.neutering = neutering;
        this.users = users;
        this.petImg = petImg;
        this.petCategory = petCategory;
    }
}
