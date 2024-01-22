package com.example.dw.domain.dto.admin.goods;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminGoodsStan {

    private Long goodsId;
    private String goodsName;
    private String goodsCategory;
    private Integer goodsQuantity;
    private Integer goodsPrice;
    private Integer goodsSaleCount;
    private String goodsDetailContent;
    private String goodsMate;
    private String goodsCertify;
    private LocalDateTime goodsRd;
    private LocalDateTime goodsMd;


    public AdminGoodsStan(Long goodsId, String goodsName, String goodsCategory, Integer goodsQuantity, Integer goodsPrice, Integer goodsSaleCount, String goodsDetailContent, LocalDateTime goodsRd, LocalDateTime goodsMd) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsCategory = goodsCategory;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsSaleCount = goodsSaleCount;
        this.goodsDetailContent = goodsDetailContent;
        this.goodsRd = goodsRd;
        this.goodsMd = goodsMd;
    }


}
