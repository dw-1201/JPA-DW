package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WalkMateDetailDto {


    private Long id;
    private Long userId;
    private String userNickName;
    private String userAccount;
    private LocalDateTime registeredDate;
    private LocalDateTime modifiedDate;
    private String title;
    private String content;
    private Long currentPerson;
    private Long matePerson;
    private String mateDate;
    private String mateTime;
    private String fullAddress;
    private String walkCity;
    private String walkCounty;
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
    private Long viewCount;
    private Long currentState;

    //state


    @QueryProjection
    public WalkMateDetailDto(Long id, Long userId, String userNickName, String userAccount, LocalDateTime registeredDate, LocalDateTime modifiedDate, String title, String content, Long currentPerson, Long matePerson, String mateDate, String mateTime, String fullAddress, String walkCity, String walkCounty, Long petId, String petName, String petCate, Long petWeight, String neutering, String petGender, Long petImgId, String petImgPath, String petImgUuid, String petImgName, Long viewCount, Long currentState) {
        this.id = id;
        this.userId = userId;
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
        this.walkCity = walkCity;
        this.walkCounty = walkCounty;
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
        this.viewCount = viewCount;
        this.currentState = currentState;
    }
}
