package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminUserPetDetailDto {


    private Long petId;
    private String birthDate;
    private String name;
    private Long weight;
    private String petGender;
    private String neutering;
    private String petCategory;
    private AdminUserPetImgDto adminUserPetImgDto;


    public AdminUserPetDetailDto(Long petId, String birthDate, String name, Long weight, String petGender, String neutering, String petCategory, AdminUserPetImgDto adminUserPetImgDto) {
        this.petId = petId;
        this.birthDate = birthDate;
        this.name = name;
        this.weight = weight;
        this.petGender = petGender;
        this.neutering = neutering;
        this.petCategory = petCategory;
        this.adminUserPetImgDto = adminUserPetImgDto;
    }


}
