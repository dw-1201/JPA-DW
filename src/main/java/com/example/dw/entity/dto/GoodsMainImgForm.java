package com.example.dw.entity.dto;

import com.example.dw.entity.goods.Goods;
import com.example.dw.entity.goods.GoodsMainImg;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsMainImgForm {

    private Long id;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private Goods goods;

    @Builder
    public GoodsMainImgForm(Long id, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid, Goods goods) {
        this.id = id;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goods=goods;
    }

    public GoodsMainImg toEntity(){
        return GoodsMainImg.builder()
                .id(id)
                .goodsMainImgName(goodsMainImgName)
                .goodsMainImgPath(goodsMainImgPath)
                .goodsMainImgUuid(goodsMainImgUuid)
                .goods(goods)
                .build();
    }
}
