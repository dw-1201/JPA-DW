package com.example.dw.domain.dto.admin;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminGoodsDto {

    private Long id;
    private String goodsName;
    private int goodsQuantity;
    private int goodsSaleCount;
    private int goodsPrice;
    private String goodsCategory;
    private LocalDateTime goodsRegisterDate;
    private LocalDateTime goodsModifyDate;


    @QueryProjection
    public AdminGoodsDto(Long id, String goodsName, int goodsQuantity, int goodsSaleCount, int goodsPrice, String goodsCategory, LocalDateTime goodsRegisterDate, LocalDateTime goodsModifyDate) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsSaleCount = goodsSaleCount;
        this.goodsPrice = goodsPrice;
        this.goodsCategory = goodsCategory;
        this.goodsRegisterDate = goodsRegisterDate;
        this.goodsModifyDate = goodsModifyDate;
    }
}
