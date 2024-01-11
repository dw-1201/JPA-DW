package com.example.dw.domain.dto.community;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WalkMateMyApplicationListDto {
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
    private Long walkingMateStateId;
    private Integer writerCheck;

    @QueryProjection

    public WalkMateMyApplicationListDto(Long id, String walkingMateTitle, String walkingMateContent, LocalDateTime walkingMateRd, Long walkingMateViewCount, Long walkingMateState, Long walkingMatePerson, Long walkingMateToday, String walkingMateDate, String walkingMateTime, String walkCity, String walkCounty, Long userId, String userNickName, String userAccount, Long petId, Long petImgId, String petFileName, String petPath, String petUuid, Long walkingMateStateId, Integer writerCheck) {
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
        this.walkingMateStateId = walkingMateStateId;
        this.writerCheck = writerCheck;
    }
}
