package com.example.dw.domain.dto.goods;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.goods.GoodsPayList;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsPayResultForm {

    private Long id;
    private Long goodsId;
    private String goodsName;
    private String goodsQuantity;
    private String goodsPrice;
    private Long userId;

    @Builder
    public GoodsPayResultForm(Long id, Long goodsId, String goodsName, String goodsQuantity, String goodsPrice, Long userId) {
        this.id = id;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.userId = userId;
    }





    public GoodsPayList toEntity(){
        return GoodsPayList.builder()
                .id(id)
                .goods(Goods.builder().id(goodsId).build())
                .users(Users.builder().id(userId).build())
                .goodsQuantity(Integer.valueOf(goodsQuantity))
                .goodsPrice(Integer.valueOf(goodsPrice))
                .build();
    }
}
