package com.example.dw.domain.form;

import com.example.dw.domain.entity.user.Pet;
import com.example.dw.domain.entity.user.PetImg;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PetImgForm {

    private Long id;

    private String petFileName;
    private String petPath;
    private String petUuid;
    private Pet pet;

    @Builder
    public PetImgForm(Long id, String petFileName, String petPath, String petUuid, Pet pet) {
        this.id = id;
        this.petFileName = petFileName;
        this.petPath = petPath;
        this.petUuid = petUuid;
        this.pet = pet;
    }

    public PetImg toEntity(){
        return PetImg.builder()
                .id(id)
                .petFileName(petFileName)
                .petPath(petPath)
                .petUuid(petUuid)
                .pet(pet)
                .build();
    }

}
