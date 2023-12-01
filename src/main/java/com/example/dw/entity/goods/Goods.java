package com.example.dw.entity.goods;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods")
@Getter
@Setter
public class Goods {
    @Id
    @GeneratedValue
    private Long id;

    private String goodsName;
    private Long goodsQuantity;
    private Long goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private GoodsCategory goodsCategory;

    @OneToOne(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private GoodsMainImg goodsMainImg;


    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private List<GoodsDetailImg> goodsDetailImg = new ArrayList<>();

}
