package com.example.dw.domain.entity.order;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static lombok.Builder.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Table(name="order_review")
public class OrderReview {
    @Id
    @GeneratedValue
    @Column(name = "order_review_id")
    private Long id;

    private String title;
    private String content;
    private Integer rating;
    @CreatedDate
    private LocalDateTime reviewRd;

    @Default
    private Long state=0L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @OneToMany(mappedBy = "orderReview",fetch = FetchType.LAZY)
    private List<OrderReviewImg> orderReviewImgList =new ArrayList<>();

    @OneToOne(mappedBy = "orderReview",fetch = FetchType.LAZY)
    private GoodsReviewReply goodsReviewReply;


    @Builder
    public OrderReview(Long id, String title, String content, Integer rating, LocalDateTime reviewRd, Long state, OrderItem orderItem, List<OrderReviewImg> orderReviewImgList, GoodsReviewReply goodsReviewReply) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.reviewRd = reviewRd;
        this.state = state;
        this.orderItem = orderItem;
        this.orderReviewImgList = orderReviewImgList;
        this.goodsReviewReply = goodsReviewReply;
    }
}
