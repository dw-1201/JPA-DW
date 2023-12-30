package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsQueReplyDto {

    private Long id;
    private String qnaReplyContent;
    private String qnaReplyRd;
    private String qnaReplyMd;

    @QueryProjection
    public AdminGoodsQueReplyDto(Long id, String qnaReplyContent, String qnaReplyRd, String qnaReplyMd) {
        this.id = id;
        this.qnaReplyContent = qnaReplyContent;
        this.qnaReplyRd = qnaReplyRd;
        this.qnaReplyMd = qnaReplyMd;
    }
}
