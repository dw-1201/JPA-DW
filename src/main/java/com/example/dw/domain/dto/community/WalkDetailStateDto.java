package com.example.dw.domain.dto.community;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkDetailStateDto {

    private Long walkMateId;
    private Long walkMateStateId;
    private Long applierUserId;
    private String applierUserAccount;
    private String applierUserNickName;
    private Long applierPetId;
    private String applierPetName;
    private Long applierPetWeight;
    private String applierPetGender;
    private String applierPetAge;
    private String applierPetCate;
    private String applierPetNeutering;
    private String applierPetImgName;
    private String applierPetImgPath;
    private String applierPetImgUuid;
    private Integer state;
    private Integer writerCheck;



    @QueryProjection

    public WalkDetailStateDto(Long walkMateId, Long walkMateStateId, Long applierUserId, String applierUserAccount, String applierUserNickName, Long applierPetId, String applierPetName, Long applierPetWeight, String applierPetGender, String applierPetAge, String applierPetCate, String applierPetNeutering, String applierPetImgName, String applierPetImgPath, String applierPetImgUuid, Integer state, Integer writerCheck) {
        this.walkMateId = walkMateId;
        this.walkMateStateId = walkMateStateId;
        this.applierUserId = applierUserId;
        this.applierUserAccount = applierUserAccount;
        this.applierUserNickName = applierUserNickName;
        this.applierPetId = applierPetId;
        this.applierPetName = applierPetName;
        this.applierPetWeight = applierPetWeight;
        this.applierPetGender = applierPetGender;
        this.applierPetAge = applierPetAge;
        this.applierPetCate = applierPetCate;
        this.applierPetNeutering = applierPetNeutering;
        this.applierPetImgName = applierPetImgName;
        this.applierPetImgPath = applierPetImgPath;
        this.applierPetImgUuid = applierPetImgUuid;
        this.state = state;
        this.writerCheck = writerCheck;
    }
}

