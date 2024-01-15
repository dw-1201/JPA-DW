package com.example.dw.domain.entity.order;

import com.example.dw.domain.entity.goods.Goods;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import static lombok.Builder.*;

@Getter
@Entity
@Table(name = "order_item")
@NoArgsConstructor
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id")
    private Orders orders;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private Goods goods;

//    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
//    @JoinColumn(name = "order_review_id")
//    private OrderReview orderReview;

    private Integer orderQuantity;
    private Integer orderPrice;

    @Default
    private Long state = 0L;

    @Builder
    public OrderItem(Long id, Orders orders, Goods goods, Integer orderQuantity, Integer orderPrice, Long state) {
        this.id = id;
        this.orders = orders;
        this.goods = goods;
//        this.orderReview = orderReview;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
        this.state = state;
    }
}
