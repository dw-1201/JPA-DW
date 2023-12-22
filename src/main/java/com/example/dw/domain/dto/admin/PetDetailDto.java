package com.example.dw.domain.dto.admin;


import com.example.dw.domain.entity.user.PetImg;
import com.example.dw.domain.entity.user.Users;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetDetailDto {

    private Long id;

    private String birthDate;
    private String name;
    private Long weight;
    private String petGender;
    private String neutering ="N";
    private Long userId;
    private Long petImgId;
    private String petFileName;
    private String petPath;
    private String petUuid;
    private String petCategory;

    @QueryProjection
    public PetDetailDto(Long id, String birthDate, String name, Long weight, String petGender, String neutering, Long userId, Long petImgId, String petFileName, String petPath, String petUuid, String petCategory) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.weight = weight;
        this.petGender = petGender;
        this.neutering = neutering;
        this.userId = userId;
        this.petImgId = petImgId;
        this.petFileName = petFileName;
        this.petPath = petPath;
        this.petUuid = petUuid;
        this.petCategory = petCategory;
    }
}
