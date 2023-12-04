package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.goods.GoodsCategory;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GoodsCategoryForm {


    private Long id;
    private String goodsCategoryName;
    private List<Goods> goods;

    @Builder
    public GoodsCategoryForm(Long id, String goodsCategoryName, List<Goods> goods) {
        this.id = id;
        this.goodsCategoryName = goodsCategoryName;
        this.goods = goods;
    }

    public GoodsCategory toEntity(){
        return GoodsCategory.builder()
                .id(id)
                .goodsCategoryName(goodsCategoryName)
                .goods(goods)
                .build();
    }

}
