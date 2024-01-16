package com.example.dw.domain.dto.admin;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AdminUserDetailDto {

    private Long id;
    private String userAccount;
    private String userName;
    private String userNickName;
    private String userPhone;
    private String userEmail;
    private LocalDate userJoinDate;
    private String zipCode;
    private String address;
    private String detail;
    private String intro;

    private Long userImgId;
    private String userImgPath;
    private String userImgUuid;
    private String userImgName;

    private Long petId;
    private String birthDate;
    private String name;
    private Long weight;
    private String petGender;
    private String neutering;
    private String petCategory;


    private Long petImgId;
    private String petImgPath;
    private String petImgUuid;
    private String petImgName;

    @QueryProjection
    public AdminUserDetailDto(Long id, String userAccount, String userName, String userNickName, String userPhone, String userEmail, LocalDate userJoinDate, String zipCode, String address, String detail, String intro, Long userImgId, String userImgPath, String userImgUuid, String userImgName, Long petId, String birthDate, String name, Long weight, String petGender, String neutering, String petCategory, Long petImgId, String petImgPath, String petImgUuid, String petImgName) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userNickName = userNickName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userJoinDate = userJoinDate;
        this.zipCode = zipCode;
        this.address = address;
        this.detail = detail;
        this.intro = intro;
        this.userImgId = userImgId;
        this.userImgPath = userImgPath;
        this.userImgUuid = userImgUuid;
        this.userImgName = userImgName;
        this.petId = petId;
        this.birthDate = birthDate;
        this.name = name;
        this.weight = weight;
        this.petGender = petGender;
        this.neutering = neutering;
        this.petCategory = petCategory;
        this.petImgId = petImgId;
        this.petImgPath = petImgPath;
        this.petImgUuid = petImgUuid;
        this.petImgName = petImgName;
    }
}
