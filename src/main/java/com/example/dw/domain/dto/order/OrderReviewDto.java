package com.example.dw.domain.dto.order;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderReviewDto {

    private Long id;

    private String title;
    private String content;
    private Integer rating;

    private LocalDateTime reviewRd;

    private Long orderItemId;
    private Long goodsId;
    private String goodsName;


    @QueryProjection

    public OrderReviewDto(Long id, String title, String content, Integer rating, LocalDateTime reviewRd, Long orderItemId, Long goodsId, String goodsName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.reviewRd = reviewRd;
        this.orderItemId = orderItemId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
    }
}
