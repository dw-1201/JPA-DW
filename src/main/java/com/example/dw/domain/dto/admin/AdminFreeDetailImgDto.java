package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminFreeDetailImgDto {


    private Long freeBoardImgId;
    private String freeBoardImgPath;
    private String freeBoardImgUuid;
    private String freeBoardImgName;



    public AdminFreeDetailImgDto(Long freeBoardImgId, String freeBoardImgPath, String freeBoardImgUuid, String freeBoardImgName) {
        this.freeBoardImgId = freeBoardImgId;
        this.freeBoardImgPath = freeBoardImgPath;
        this.freeBoardImgUuid = freeBoardImgUuid;
        this.freeBoardImgName = freeBoardImgName;
    }
}
