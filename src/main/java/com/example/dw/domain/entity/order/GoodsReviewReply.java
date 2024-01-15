package com.example.dw.domain.entity.order;


import jakarta.persistence.*;

import static lombok.Builder.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="goods_review_reply")
@Getter
@NoArgsConstructor
public class GoodsReviewReply {
    @Id
    @GeneratedValue
    private Long id;

    private String goodsReviewReplyContent;
    private LocalDateTime  goodsReviewReplyRD;
    private LocalDateTime  goodsReviewReplyMD;
    @Default
    private Integer state=0;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="order_review_id")
    private OrderReview orderReview;
}
