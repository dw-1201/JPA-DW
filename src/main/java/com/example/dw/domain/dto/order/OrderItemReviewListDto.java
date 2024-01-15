package com.example.dw.domain.dto.order;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
public class OrderItemReviewListDto {

    //아이템 아이디
    private Long id;

    private Long orderItemId;
    private String title;
    private String content;
    private Integer rating;

    private LocalDateTime reviewRd;


    private Long goodsId;
    private String goodsName;

    private Long orderId;

    private Long userId;

    @QueryProjection
    public OrderItemReviewListDto(Long id, Long orderItemId, String title, String content, Integer rating, LocalDateTime reviewRd, Long goodsId, String goodsName, Long orderId, Long userId) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.reviewRd = reviewRd;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.orderId = orderId;
        this.userId = userId;
    }









    @Override
    public String toString() {
        return "OrderItemReviewListDto{" +
                "id=" + id +

                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rating=" + rating +
                ", reviewRd=" + reviewRd +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", orderId=" + orderId +
                ", userId=" + userId +
                '}';
    }
}
