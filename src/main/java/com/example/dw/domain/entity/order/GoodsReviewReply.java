package com.example.dw.domain.entity.order;


import com.example.dw.domain.form.GoodsReviewReplyForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity

@Table(name="goods_review_reply")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsReviewReply {
    @Id
    @GeneratedValue
    @Column(name="goods_review_reply_id")
    private Long id;

    private String goodsReviewReplyContent;
    @CreatedDate
    private LocalDateTime  goodsReviewReplyRD;
    @LastModifiedDate
    private LocalDateTime  goodsReviewReplyMD;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="order_review_id")
    private OrderReview orderReview;


    @Builder
    public GoodsReviewReply(Long id, String goodsReviewReplyContent, LocalDateTime goodsReviewReplyRD, LocalDateTime goodsReviewReplyMD, OrderReview orderReview) {
        this.id = id;
        this.goodsReviewReplyContent = goodsReviewReplyContent;
        this.goodsReviewReplyRD = goodsReviewReplyRD;
        this.goodsReviewReplyMD = goodsReviewReplyMD;
        this.orderReview = orderReview;
    }


    public GoodsReviewReply update(GoodsReviewReplyForm goodsReviewReplyForm){
        this.goodsReviewReplyContent = goodsReviewReplyForm.getGoodsReviewReplyContent();
        this.goodsReviewReplyMD=LocalDateTime.now();
        return this;
    }
}
