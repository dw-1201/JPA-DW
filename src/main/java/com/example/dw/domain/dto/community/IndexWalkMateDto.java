package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IndexWalkMateDto {

        private Long walkMateId;
        private String walkCity;
        private String walkCounty;
        private String walkMateTitle;
        private Long walkMateState;
        private Long userId;
        private String writerPetImgPath;
        private String writerPetImgUuid;
        private String writerPetImgName;


        @QueryProjection

    public IndexWalkMateDto(Long walkMateId, String walkCity, String walkCounty, String walkMateTitle, Long walkMateState, Long userId, String writerPetImgPath, String writerPetImgUuid, String writerPetImgName) {
        this.walkMateId = walkMateId;
        this.walkCity = walkCity;
        this.walkCounty = walkCounty;
        this.walkMateTitle = walkMateTitle;
        this.walkMateState = walkMateState;
        this.userId = userId;
        this.writerPetImgPath = writerPetImgPath;
        this.writerPetImgUuid = writerPetImgUuid;
        this.writerPetImgName = writerPetImgName;
    }
}
