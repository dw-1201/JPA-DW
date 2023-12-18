package com.example.dw.domain.dto.admin;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsDto {

    private Long id;
    private String goodsName;
    private int goodsQuantity;
    private int goodsPrice;
    private String goodsCategory;
    private String goodsRegisterDate;
    private String goodsModifyDate;


    @QueryProjection
    public AdminGoodsDto(Long id, String goodsName, int goodsQuantity, int goodsPrice, String categoryName, String goodsRegisterDate, String goodsModifyDate) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsCategory = categoryName;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
    }
}
