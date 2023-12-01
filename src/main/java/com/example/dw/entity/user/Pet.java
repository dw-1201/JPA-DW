package com.example.dw.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static lombok.Builder.*;

@Entity
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Users users;

    @OneToOne(mappedBy = "pet" ,fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_img_id")
    private PetImg petImg;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private PetCategory petCategory;

}
