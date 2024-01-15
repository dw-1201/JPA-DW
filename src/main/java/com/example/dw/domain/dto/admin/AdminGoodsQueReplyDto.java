package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsQueReplyDto {

    private Long id;
    private String qnaReplyContent;
    private LocalDateTime qnaReplyRd;
    private LocalDateTime qnaReplyMd;

    @QueryProjection
    public AdminGoodsQueReplyDto(Long id, String qnaReplyContent, LocalDateTime qnaReplyRd, LocalDateTime qnaReplyMd) {
        this.id = id;
        this.qnaReplyContent = qnaReplyContent;
        this.qnaReplyRd = qnaReplyRd;
        this.qnaReplyMd = qnaReplyMd;
    }
}
