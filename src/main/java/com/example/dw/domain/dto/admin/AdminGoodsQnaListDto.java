package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsQnaListDto {


        private Long id;
        private String goodsCategory;
        private Long goodsId;
        private String goodsName;
        private String qnaContent;
        private LocalDateTime qnaRd;
        private Integer state;

    @QueryProjection
    public AdminGoodsQnaListDto(Long id, String goodsCategory, Long goodsId, String goodsName, String qnaContent, LocalDateTime qnaRd, Integer state) {
        this.id = id;
        this.goodsCategory = goodsCategory;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.qnaContent = qnaContent;
        this.qnaRd = qnaRd;
        this.state = state;
    }
}
