package com.example.dw.domain.entity.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pet_img")
public class PetImg {
    @Id @GeneratedValue
    @Column(name = "pet_img_id")
    private Long id;

    private String petFileName;
    private String petPath;
    private String petUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    private Pet pet;


    @Builder
    public PetImg(Long id, String petFileName, String petPath, String petUuid, Pet pet) {
        this.id = id;
        this.petFileName = petFileName;
        this.petPath = petPath;
        this.petUuid = petUuid;
        this.pet = pet;
    }
}
