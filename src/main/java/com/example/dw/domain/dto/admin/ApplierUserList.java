package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApplierUserList {

    private Long stateId; //WalkingMateState Id
    private Long applierUserId; //신청회원 id
    private String applierUserAccount;
    private Long applierPetId; //신청회원 펫id
    private String applierPetCate;
    private String applierPetName;
    private Long applierPetWeight;
    private String applierPetGender;
    private String applierPetNeutering;
    private String applierPetBirth;

    private String applierPetImgPath;
    private String applierPetImgUuid;
    private String applierPetImgName;
    private Integer state; //신청상태


    @QueryProjection

    public ApplierUserList(Long stateId, Long applierUserId, String applierUserAccount, Long applierPetId, String applierPetCate, String applierPetName, Long applierPetWeight, String applierPetGender, String applierPetNeutering, String applierPetBirth, String applierPetImgPath, String applierPetImgUuid, String applierPetImgName, Integer state) {
        this.stateId = stateId;
        this.applierUserId = applierUserId;
        this.applierUserAccount = applierUserAccount;
        this.applierPetId = applierPetId;
        this.applierPetCate = applierPetCate;
        this.applierPetName = applierPetName;
        this.applierPetWeight = applierPetWeight;
        this.applierPetGender = applierPetGender;
        this.applierPetNeutering = applierPetNeutering;
        this.applierPetBirth = applierPetBirth;
        this.applierPetImgPath = applierPetImgPath;
        this.applierPetImgUuid = applierPetImgUuid;
        this.applierPetImgName = applierPetImgName;
        this.state = state;
    }
}
