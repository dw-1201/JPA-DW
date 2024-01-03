package com.example.dw.domain.entity.goods;


import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="goods_pay_list")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsPayList {

    @Id
    @GeneratedValue @Column(name="goods_pay_id")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="goods_id")
    private Goods goods;

    private Integer goodsQuantity;
    private Integer goodsPrice;

    @Builder
    public GoodsPayList(Long id, Users users, Goods goods, Integer goodsQuantity, Integer goodsPrice) {
        this.id = id;
        this.users = users;
        this.goods = goods;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
    }
}
