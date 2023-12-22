package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class PetDetailResultDto {

    private Long id;

    private String birthDate;
    private String name;
    private Long weight;
    private String petGender;
    private String neutering = "N";
    private Long userId;
    private String petCategory;
    private List<PetImgDetailDto> petImgDetailDtoList;

    public PetDetailResultDto(Long id, String birthDate, String name, Long weight, String petGender, String neutering, Long userId, String petCategory, List<PetImgDetailDto> petImgDetailDtoList) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.weight = weight;
        this.petGender = petGender;
        this.neutering = neutering;
        this.userId = userId;
        this.petCategory = petCategory;
        this.petImgDetailDtoList = petImgDetailDtoList;
    }

    public PetDetailResultDto(Long id, String birthDate, String name, Long weight, String petGender, String neutering, Long userId, String petCategory) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.weight = weight;
        this.petGender = petGender;
        this.neutering = neutering;
        this.userId = userId;
        this.petCategory = petCategory;
    }

    @Override
    public String toString() {
        return "PetDetailResultDto{" +
                "id=" + id +
                ", birthDate='" + birthDate + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", petGender='" + petGender + '\'' +
                ", neutering='" + neutering + '\'' +
                ", userId=" + userId +
                ", petCategory='" + petCategory + '\'' +
                ", petImgDetailDtoList=" + petImgDetailDtoList +
                '}';
    }
}