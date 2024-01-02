package com.example.dw.domain.dto.community;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WalkDetailStateDto {

    private Long walkMateStateId;
    private Long walkMateId;
    private Long applierUserId;
    private Long applierPetId;
    private Long applierPetName;
    private Long applierPetAge;
    private Long applierPetCate;
    private Long state;


    public WalkDetailStateDto(Long walkMateStateId, Long walkMateId, Long applierUserId, Long applierPetId, Long applierPetName, Long applierPetAge, Long applierPetCate, Long state) {
        this.walkMateStateId = walkMateStateId;
        this.walkMateId = walkMateId;
        this.applierUserId = applierUserId;
        this.applierPetId = applierPetId;
        this.applierPetName = applierPetName;
        this.applierPetAge = applierPetAge;
        this.applierPetCate = applierPetCate;
        this.state = state;
    }
}
