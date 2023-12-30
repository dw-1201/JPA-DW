package com.example.dw.domain.entity.goods;

import com.example.dw.domain.form.GoodsForm;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude={"goodsMainImg", "goodsDetailImg"})
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
    private String goodsRegisterDate ;
    @LastModifiedDate
    private String goodsModifyDate;

    @Enumerated(EnumType.STRING)
    private GoodsCategory goodsCategory;

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GoodsMainImg> goodsMainImg = new ArrayList<>();

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GoodsDetailImg> goodsDetailImg = new ArrayList<>();

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY, orphanRemoval = true)
    private List<GoodsQue> goodsQues = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public Goods(Long id, String goodsName, int goodsQuantity, int goodsPrice, GoodsCategory goodsCategory){
        this.id=id;
        this.goodsName=goodsName;
        this.goodsQuantity=goodsQuantity;
        this.goodsPrice=goodsPrice;
        this.goodsCategory=goodsCategory;
    }

    @Builder
    public Goods(Long id, String goodsName, int goodsQuantity, int goodsPrice, String goodsMade, String goodsCertify, String goodsDetailContent, String goodsRegisterDate, String goodsModifyDate, GoodsCategory goodsCategory, List<GoodsMainImg> goodsMainImg, List<GoodsDetailImg> goodsDetailImg, List<GoodsQue> goodsQues, Cart cart) {
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
        this.cart = cart;
    }

    //상품 수정
    public Goods update(GoodsForm goodsForm){
        this.goodsName= goodsForm.getGoodsName();
        this.goodsQuantity= goodsForm.getGoodsQuantity();
        this.goodsPrice= goodsForm.getGoodsPrice();
        this.goodsDetailContent=goodsForm.getGoodsDetailContent();
        this.goodsMade= goodsForm.getGoodsMade();
        this.goodsCertify= goodsForm.getGoodsCertify();
        this.goodsModifyDate=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        this.goodsCategory=goodsForm.getGoodsCategory();

        return this;
    }

    //날짜포맷
    @PrePersist
    public void onPrePersist(){
        this.goodsRegisterDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        this.goodsModifyDate=this.goodsRegisterDate;
    }
    
    @PreUpdate
    public void onPreUpdate(){
        this.goodsModifyDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }


}
