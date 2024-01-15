package com.example.dw.domain.entity.order;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="order_review_img")
@Getter
@NoArgsConstructor

public class OrderReviewImg {
    @Id
    @GeneratedValue
    private Long id;

    private String reviewimgFileName;
    private String reviewimgPath;
    private String reviewimgUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_review_id")
    private OrderReview orderReview;

    @Builder
    public OrderReviewImg(Long id, String reviewimgFileName, String reviewimgPath, String reviewimgUuid, OrderReview orderReview) {
        this.id = id;
        this.reviewimgFileName = reviewimgFileName;
        this.reviewimgPath = reviewimgPath;
        this.reviewimgUuid = reviewimgUuid;
        this.orderReview = orderReview;
    }
}
