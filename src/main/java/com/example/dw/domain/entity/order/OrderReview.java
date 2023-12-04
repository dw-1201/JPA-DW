package com.example.dw.domain.entity.order;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static lombok.Builder.*;

@Entity
@Setter
@Getter
@Table(name="order_review")
public class OrderReview {
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String content;
    private Integer rating;

    @Default
    private Long state=0L;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_list_id")
    private OrderList orderList;

    @OneToMany(mappedBy = "orderReview",fetch = FetchType.LAZY)
    private List<OrderReviewImg> orderReviewImgList =new ArrayList<>();

    @OneToOne(mappedBy = "orderReview",fetch = FetchType.LAZY)
    private GoodsReviewReply goodsReviewReply;

}
