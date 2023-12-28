package com.example.dw.domain.dto.admin;


import com.example.dw.domain.entity.user.Pet;
import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetImgDetailDto {
    private Long id;
    private String petFileName;
    private String petPath;
    private String petUuid;
    private Long petId;


    public PetImgDetailDto(Long id, String petFileName, String petPath, String petUuid, Long petId) {
        this.id = id;
        this.petFileName = petFileName;
        this.petPath = petPath;
        this.petUuid = petUuid;
        this.petId = petId;
    }
}
