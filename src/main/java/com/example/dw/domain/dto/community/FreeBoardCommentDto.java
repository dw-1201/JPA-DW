package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FreeBoardCommentDto {

    private Long freeBoardCommentId;
    private String freeBoardCommentContent;
    private LocalDateTime freeBoardCommentRd;
    private LocalDateTime freeBoardCommentMd;

    //자유게시판 글 번호
    private Long freeBoardId;



    @QueryProjection
    @Builder
    public FreeBoardCommentDto(Long freeBoardCommentId,
                               String freeBoardCommentContent,
                               LocalDateTime freeBoardCommentRd,
                               LocalDateTime freeBoardCommentMd,
                               Long freeBoardId) {
        this.freeBoardCommentId = freeBoardCommentId;
        this.freeBoardCommentContent = freeBoardCommentContent;
        this.freeBoardCommentRd = freeBoardCommentRd;
        this.freeBoardCommentMd = freeBoardCommentMd;

        //자유게시판 글 번호
        this.freeBoardId = freeBoardId;
    }

// FreeBoardCommentDto 클래스 생성자
//    @QueryProjection
//    public FreeBoardCommentDto(@Param("freeBoardCommentId") Long freeBoardCommentId,
//                               @Param("freeBoardCommentContent") String freeBoardCommentContent,
//                               @Param("freeBoardCommentRd") LocalDateTime freeBoardCommentRd,
//                               @Param("freeBoardCommentMd") LocalDateTime freeBoardCommentMd,
//                               @Param("freeBoardId") Long freeBoardId) {
//    }



}
