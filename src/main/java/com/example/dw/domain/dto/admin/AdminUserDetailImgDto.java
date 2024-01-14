package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminUserDetailImgDto {

    private Long userImgId;
    private String userImgPath;
    private String userImgUuid;
    private String userImgName;


    public AdminUserDetailImgDto(Long userImgId, String userImgPath, String userImgUuid, String userImgName) {
        this.userImgId = userImgId;
        this.userImgPath = userImgPath;
        this.userImgUuid = userImgUuid;
        this.userImgName = userImgName;
    }
}
