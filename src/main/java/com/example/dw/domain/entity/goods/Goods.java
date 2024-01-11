package com.example.dw.domain.entity.goods;

import com.example.dw.domain.form.GoodsForm;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
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
    private int goodsQuantity;
    private int goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;
    @CreatedDate
    private LocalDateTime goodsRegisterDate ;
    @LastModifiedDate
    private LocalDateTime goodsModifyDate;

    @Enumerated(EnumType.STRING)
    private GoodsCategory goodsCategory;

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GoodsMainImg> goodsMainImg = new ArrayList<>();

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GoodsDetailImg> goodsDetailImg = new ArrayList<>();

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GoodsQue> goodsQues = new ArrayList<>();

    @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CartItem> cartItem = new ArrayList<>();

    public Goods(Long id, String goodsName, int goodsQuantity, int goodsPrice, GoodsCategory goodsCategory){
        this.id=id;
        this.goodsName=goodsName;
        this.goodsQuantity=goodsQuantity;
        this.goodsPrice=goodsPrice;
        this.goodsCategory=goodsCategory;
    }

    @Builder
    public Goods(Long id, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate, GoodsCategory goodsCategory, List<GoodsMainImg> goodsMainImg, List<GoodsDetailImg> goodsDetailImg, List<GoodsQue> goodsQues, List<CartItem> cartItem) {
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
        this.goodsQues = goodsQues;
        this.cartItem = cartItem;
    }

    //상품 수정
    public Goods update(GoodsForm goodsForm){
        this.goodsName= goodsForm.getGoodsName();
        this.goodsQuantity= goodsForm.getGoodsQuantity();
        this.goodsPrice= goodsForm.getGoodsPrice();
        this.goodsDetailContent=goodsForm.getGoodsDetailContent();
        this.goodsMade= goodsForm.getGoodsMade();
        this.goodsCertify= goodsForm.getGoodsCertify();
        this.goodsModifyDate=LocalDateTime.now();
        this.goodsCategory=goodsForm.getGoodsCategory();

        return this;
    }

}
