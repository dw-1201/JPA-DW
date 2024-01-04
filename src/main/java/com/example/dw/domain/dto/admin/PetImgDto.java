package com.example.dw.domain.dto.admin;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class PetImgDto {
    private Long id;
    private String petFileName;
    private String petPath;
    private String petUuid;
    private Long petId;

    @QueryProjection
    public PetImgDto(Long id, String petFileName, String petPath, String petUuid, Long petId) {
        this.id = id;
        this.petFileName = petFileName;
        this.petPath = petPath;
        this.petUuid = petUuid;
        this.petId = petId;
    }
}
