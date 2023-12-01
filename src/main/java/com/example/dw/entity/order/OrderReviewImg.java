package com.example.dw.entity.order;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_review_img")
@Getter
@Setter
public class OrderReviewImg {
    @Id
    @GeneratedValue
    private Long id;

    private String reviewimgFileName;
    private String reviewimgPath;
    private String reviewimgUuid;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_review_id")
    private OrderReview orderReview;
}
