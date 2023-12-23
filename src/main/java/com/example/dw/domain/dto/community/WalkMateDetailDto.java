package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkMateDetailDto {


    private Long id;
    private String userNickName;
    private String userAccount;
    private String registeredDate;
    private String modifiedDate;
    private String title;
    private String content;
    private Long currentPerson;
    private Long matePerson;
    private String mateDate;
    private String mateTime;
    private String fullAddress;
    private Long petId;
    private String petName;
    private String petCate;
    private Long petWeight;
    private String neutering;
    private String petGender;
    private Long petImgId;
    private String petImgPath;
    private String petImgUuid;
    private String petImgName;



    @QueryProjection
    public WalkMateDetailDto(Long id, String userNickName, String userAccount,
                             String registeredDate, String modifiedDate, String title, String content,
                             Long currentPerson, Long matePerson, String mateDate, String mateTime, String fullAddress,
                             Long petId, String petName, String petCate, Long petWeight, String neutering, String petGender,
                             Long petImgId, String petImgPath, String petImgUuid, String petImgName) {
        this.id = id;
        this.userNickName = userNickName;
        this.userAccount = userAccount;
        this.registeredDate = registeredDate;
        this.modifiedDate = modifiedDate;
        this.title = title;
        this.content = content;
        this.currentPerson = currentPerson;
        this.matePerson = matePerson;
        this.mateDate = mateDate;
        this.mateTime = mateTime;
        this.fullAddress = fullAddress;
        this.petId = petId;
        this.petName = petName;
        this.petCate = petCate;
        this.petWeight = petWeight;
        this.neutering = neutering;
        this.petGender = petGender;
        this.petImgId = petImgId;
        this.petImgPath = petImgPath;
        this.petImgUuid = petImgUuid;
        this.petImgName = petImgName;
    }
}
