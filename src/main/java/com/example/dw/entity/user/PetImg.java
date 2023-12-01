package com.example.dw.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pet_img")
public class PetImg {
    @Id @GeneratedValue
    @Column(name = "pet_img_id")
    private Long id;

    private String petFileName;
    private String petPath;
    private String petUuid;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
