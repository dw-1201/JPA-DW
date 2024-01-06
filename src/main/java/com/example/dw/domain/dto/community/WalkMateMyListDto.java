package com.example.dw.domain.dto.community;


import com.example.dw.domain.dto.admin.PetImgDto;
import com.example.dw.domain.entity.user.PetImg;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class WalkMateMyListDto {
    private Long id;
    private String walkingMateTitle;
    private String walkingMateContent;
    private LocalDateTime walkingMateRd;
    private Long walkingMateViewCount = 0L;
    private Long walkingMateState;
    private Long walkingMatePerson;
    private Long walkingMateToday;
    private String walkingMateDate;
    private String walkingMateTime;
    private String walkCity;
    private String walkCounty;
    private Long userId;
    private String userNickName;
    private String userAccount;
    private Long petId;
    private Long petImgId;
    private String petFileName;
    private String petPath;
    private String petUuid;
    @QueryProjection

    public WalkMateMyListDto(Long id, String walkingMateTitle, String walkingMateContent, LocalDateTime walkingMateRd, Long walkingMateViewCount, Long walkingMateState, Long walkingMatePerson, Long walkingMateToday, String walkingMateDate, String walkingMateTime, String walkCity, String walkCounty, Long userId, String userNickName, String userAccount, Long petId, Long petImgId, String petFileName, String petPath, String petUuid) {
        this.id = id;
        this.walkingMateTitle = walkingMateTitle;
        this.walkingMateContent = walkingMateContent;
        this.walkingMateRd = walkingMateRd;
        this.walkingMateViewCount = walkingMateViewCount;
        this.walkingMateState = walkingMateState;
        this.walkingMatePerson = walkingMatePerson;
        this.walkingMateToday = walkingMateToday;
        this.walkingMateDate = walkingMateDate;
        this.walkingMateTime = walkingMateTime;
        this.walkCity = walkCity;
        this.walkCounty = walkCounty;
        this.userId = userId;
        this.userNickName = userNickName;
        this.userAccount = userAccount;
        this.petId = petId;
        this.petImgId = petImgId;
        this.petFileName = petFileName;
        this.petPath = petPath;
        this.petUuid = petUuid;
    }
}
