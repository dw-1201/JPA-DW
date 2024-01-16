package com.example.dw.domain.dto.admin;

import com.example.dw.domain.entity.goods.GoodsCategory;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsSaleByCategory {

    private GoodsCategory goodsCategory;
    private Integer goodsSaleCount;



    @QueryProjection

    public GoodsSaleByCategory(GoodsCategory goodsCategory, Integer goodsSaleCount) {
        this.goodsCategory = goodsCategory;
        this.goodsSaleCount = goodsSaleCount;
    }
}
