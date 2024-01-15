package com.example.dw.domain.form;

import com.example.dw.domain.entity.order.OrderItem;
import com.example.dw.domain.entity.order.OrderReview;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderReviewForm {

    //리뷰 번호
    private Long id;
    private Long orderItemId;
    private String title;
    private String content;
    private LocalDateTime reviewRd;
    private Integer rating;

    @Builder
    public OrderReviewForm(Long id, Long orderItemId, String title, String content, LocalDateTime reviewRd, Integer rating) {
        this.id = id;
        this.orderItemId = orderItemId;
        this.title = title;
        this.content = content;
        this.reviewRd = reviewRd;
        this.rating = rating;

    }



    public OrderReview toEntity(){
        return OrderReview.builder()
                .id(id)
                .orderItem(OrderItem.builder().id(orderItemId).build())
                .title(title)
                .content(content)
                .reviewRd(reviewRd)
                .rating(rating)
                .build();
    }
}
