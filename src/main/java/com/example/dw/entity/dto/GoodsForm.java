package com.example.dw.entity.dto;

import com.example.dw.entity.goods.Goods;
import com.example.dw.entity.goods.GoodsCategory;
import com.example.dw.entity.goods.GoodsDetailImg;
import com.example.dw.entity.goods.GoodsMainImg;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class GoodsForm {

    private Long id;
    private String goodsName;
    private Long goodsQuantity;
    private Long goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;

    private GoodsCategory goodsCategory;


    @Builder
    public GoodsForm(Long id, String goodsName, Long goodsQuantity, Long goodsPrice, String goodsMade,
                     String goodsCertify, String goodsDetailContent, LocalDateTime goodsRegisterDate,
                     LocalDateTime goodsModifyDate, GoodsCategory goodsCategory) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsCertify = goodsCertify;
        this.goodsDetailContent = goodsDetailContent;

        this.goodsCategory = goodsCategory;
    }

    public Goods toEntity(){
        return Goods.builder()
                .id(id)
                .goodsName(goodsName)
                .goodsPrice(goodsPrice)
                .goodsMade(goodsMade)
                .goodsQuantity(goodsQuantity)
                .goodsCertify(goodsCertify)
                .goodsCategory(goodsCategory)
                .goodsDetailContent(goodsDetailContent)
                .build();
    }


}
