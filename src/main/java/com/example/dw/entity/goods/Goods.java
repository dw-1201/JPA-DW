package com.example.dw.entity.goods;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import lombok.Builder.Default;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Goods {
    @Id
    @GeneratedValue
    @Column(name="goods_id")
    private Long id;

    private String goodsName;
    private Long goodsQuantity;
    private Long goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;
    @Default
    private LocalDateTime goodsRegisterDate = LocalDateTime.now();
    @Default
    private LocalDateTime goodsModifyDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private GoodsCategory goodsCategory;

    @OneToOne(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private GoodsMainImg goodsMainImg;

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private List<GoodsDetailImg> goodsDetailImg = new ArrayList<>();


    @Builder
    public Goods(Long id, String goodsName, Long goodsQuantity, Long goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, LocalDateTime goodsRegisterDate,
                 LocalDateTime goodsModifyDate, GoodsCategory goodsCategory, GoodsMainImg goodsMainImg, List<GoodsDetailImg> goodsDetailImg) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsCertify = goodsCertify;
        this.goodsDetailContent = goodsDetailContent;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
        this.goodsCategory = goodsCategory;
        this.goodsMainImg = goodsMainImg;
        this.goodsDetailImg = goodsDetailImg;
    }
}
