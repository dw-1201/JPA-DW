package com.example.dw.domain.dto.admin;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetDto {

    private Long id;

    private String birthDate;
    private String name;
    private Long weight;
    private String petGender;
    private String neutering ="N";
    private Long userId;
    private String petCategory;

    @QueryProjection
    public PetDto(Long id, String birthDate, String name, Long weight, String petGender, String neutering, Long userId, String petCategory) {
        this.id = id;
        this.birthDate = birthDate;
        this.name = name;
        this.weight = weight;
        this.petGender = petGender;
        this.neutering = neutering;
        this.userId = userId;
        this.petCategory = petCategory;
    }
}
