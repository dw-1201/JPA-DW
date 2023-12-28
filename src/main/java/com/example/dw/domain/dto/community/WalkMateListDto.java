package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkMateListDto {

    private Long id;
    private String walkingMateTitle;
    private String walkingMateRd;
    private Long walkingMateViewCount = 0L;
    private Long walkingMateState;
    private Long walkingMatePerson;
    private Long walkingMateToday = 1L;
    private String walkingMateDate;
    private String walkingMateTime;
    private String walkCity;
    private String walkCounty;
    private Long userId;
    private String userNickName;
    private String userAccount;


    @QueryProjection
    public WalkMateListDto(Long id, String walkingMateTitle, String walkingMateRd, Long walkingMateViewCount, Long walkingMateState, Long walkingMatePerson, Long walkingMateToday, String walkingMateDate, String walkingMateTime, String walkCity, String walkCounty, Long userId, String userNickName, String userAccount) {
        this.id = id;
        this.walkingMateTitle = walkingMateTitle;
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
    }
}
