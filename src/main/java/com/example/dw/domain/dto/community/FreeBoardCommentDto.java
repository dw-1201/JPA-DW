package com.example.dw.domain.dto.community;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class FreeBoardCommentDto {

    private Long id;
    private String freeBoardCommentContent;
    private LocalDateTime freeBoardCommentRd;
    private LocalDateTime freeBoardCommentMd;

    //자유게시판 글 번호
    private Long freeBoardId;
    private Long userId;



    @QueryProjection

    public FreeBoardCommentDto(Long id, String freeBoardCommentContent, LocalDateTime freeBoardCommentRd, LocalDateTime freeBoardCommentMd, Long freeBoardId, Long userId) {
        this.id = id;
        this.freeBoardCommentContent = freeBoardCommentContent;
        this.freeBoardCommentRd = freeBoardCommentRd;
        this.freeBoardCommentMd = freeBoardCommentMd;
        this.freeBoardId = freeBoardId;
        this.userId = userId;
    }
}
