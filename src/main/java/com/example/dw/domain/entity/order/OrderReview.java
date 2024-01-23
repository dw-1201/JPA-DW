package com.example.dw.domain.entity.order;


import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_item_id")
    private OrderItem orderItem;

    @OneToMany(mappedBy = "orderReview",fetch = FetchType.LAZY)
    private List<OrderReviewImg> orderReviewImgList =new ArrayList<>();

    @OneToMany(mappedBy = "orderReview",fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GoodsReviewReply> goodsReviewReply;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private Users users;

    @Builder.Default
    private Integer adminReplyState = 0;


    @Builder
    public OrderReview(Long id, String title, String content, Integer rating, LocalDateTime reviewRd, OrderItem orderItem, List<OrderReviewImg> orderReviewImgList, List<GoodsReviewReply> goodsReviewReply, Integer adminReplyState) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rating = rating;
        this.reviewRd = reviewRd;
        this.orderItem = orderItem;
        this.orderReviewImgList = orderReviewImgList;
        this.goodsReviewReply = goodsReviewReply;
        this.adminReplyState = adminReplyState;
    }
}
