package com.example.dw.domain.entity.order;

import com.example.dw.domain.entity.goods.Goods;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "order_item")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    private Integer orderQuantity;
    private Integer orderPrice;

    @Builder
    public OrderItem(Long id, Orders orders, Goods goods, Integer orderQuantity, Integer orderPrice) {
        this.id = id;
        this.orders = orders;
        this.goods = goods;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }
}
