package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminUserPetImgDto {


    private Long petImgId;
    private String petImgPath;
    private String petImgUuid;
    private String petImgName;


    public AdminUserPetImgDto(Long petImgId, String petImgPath, String petImgUuid, String petImgName) {
        this.petImgId = petImgId;
        this.petImgPath = petImgPath;
        this.petImgUuid = petImgUuid;
        this.petImgName = petImgName;
    }
}
