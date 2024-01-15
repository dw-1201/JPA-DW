package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

// 파일에 저장되어 있는 이미지 전체 뽑기
@Data
@NoArgsConstructor
public class FreeBoardImgDto {

    private Long id;
    private String freeBoardImgRoute;
    private String freeBoardImgName;
    private String freeBoardImgUuid;

    //자유게시판 번호
    private Long freeBoarId;

    @QueryProjection
    public FreeBoardImgDto(Long id, String freeBoardImgRoute, String freeBoardImgName, String freeBoardImgUuid, Long freeBoarId) {
        this.id = id;
        this.freeBoardImgRoute = freeBoardImgRoute;
        this.freeBoardImgName = freeBoardImgName;
        this.freeBoardImgUuid = freeBoardImgUuid;
        this.freeBoarId = freeBoarId;
    }
}
