package com.example.dw.domain.form;

import com.example.dw.domain.entity.order.GoodsReviewReply;
import com.example.dw.domain.entity.order.OrderReview;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsReviewReplyForm {

    private Long id;
    private String goodsReviewReplyContent;
    private Long orderReviewId;

    @Builder
    public GoodsReviewReplyForm(Long id, String goodsReviewReplyContent, Long orderReviewId) {
        this.id = id;
        this.goodsReviewReplyContent = goodsReviewReplyContent;
        this.orderReviewId = orderReviewId;
    }

    public GoodsReviewReply toEntity(){
        return GoodsReviewReply.builder()
                .id(id)
                .goodsReviewReplyContent(goodsReviewReplyContent)
                .orderReview(OrderReview.builder().id(orderReviewId).build())
                .build();
    }
}
