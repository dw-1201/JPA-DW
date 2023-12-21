package com.example.dw.domain.form;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.entity.walkingMate.WalkingMate;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkMateForm {


    private Long id;
    private String walkingMateTitle;
    private String walkingMateContent;
    private Long walkingMatePerson;
    private String walkingMateDate;
    private String walkingMateTime;
    private String walkingMateFullAddress;
    private String walkCity;
    private String walkCounty;
    private Long userId;



    @Builder
    public WalkMateForm(Long id, String walkingMateTitle, String walkingMateContent, Long walkingMatePerson, String walkingMateDate, String walkingMateTime, String walkingMateFullAddress, String walkCity, String walkCounty, Long userId) {
        this.id = id;
        this.walkingMateTitle = walkingMateTitle;
        this.walkingMateContent = walkingMateContent;
        this.walkingMatePerson = walkingMatePerson;
        this.walkingMateDate = walkingMateDate;
        this.walkingMateTime = walkingMateTime;
        this.walkingMateFullAddress = walkingMateFullAddress;
        this.walkCity = walkCity;
        this.walkCounty = walkCounty;
        this.userId = userId;
    }



    public WalkingMate toEntity(){
        return WalkingMate.builder()
                .id(id)
                .walkingMateTitle(walkingMateTitle)
                .walkingMateContent(walkingMateContent)
                .walkingMatePerson(walkingMatePerson)
                .walkingMateDate(walkingMateDate)
                .walkingMateTime(walkingMateTime)
                .walkingMateFullAddress(walkingMateFullAddress)
                .walkCity(walkCity)
                .walkCounty(walkCounty)
                .users(Users.builder().id(userId).build())
                .build();
    }


}
