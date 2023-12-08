package com.example.dw.domain.entity.goods;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude={"goodsMainImg", "goodsDetailImg"})
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private String goodsRegisterDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    @LastModifiedDate
    private String goodsModifyDate;


    @Enumerated(EnumType.STRING)
    private GoodsCategory goodsCategory;


    @OneToOne(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private GoodsMainImg goodsMainImg;

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private List<GoodsDetailImg> goodsDetailImg = new ArrayList<>();



    public Goods(Long id, String goodsName, Long goodsQuantity, Long goodsPrice, GoodsCategory goodsCategory){
        this.id=id;
        this.goodsName=goodsName;
        this.goodsQuantity=goodsQuantity;
        this.goodsPrice=goodsPrice;
        this.goodsCategory=goodsCategory;
    }

    @Builder
    public Goods(Long id, String goodsName, Long goodsQuantity, Long goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, String goodsRegisterDate,
                 String goodsModifyDate, GoodsCategory goodsCategory, GoodsMainImg goodsMainImg, List<GoodsDetailImg> goodsDetailImg) {
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
