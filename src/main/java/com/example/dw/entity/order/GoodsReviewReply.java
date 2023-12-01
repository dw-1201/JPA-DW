package com.example.dw.entity.order;


import jakarta.persistence.*;
import lombok.Builder;
import static lombok.Builder.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="goods_review_reply")
@Getter
@Setter
public class GoodsReviewReply {
    @Id
    @GeneratedValue
    private Long id;

    private String goodsReviewReplyContent;
    private LocalDateTime  goodsReviewReplyRD;
    private LocalDateTime  goodsReviewReplyMD;
    @Default
    private Integer state=0;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name ="order_review_id")
    private OrderReview orderReview;
}
