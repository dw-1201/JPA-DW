package com.example.dw.domain.dto.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsDetailImgDto {


    private Long id;
    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;


    public GoodsDetailImgDto(Long id, String goodsDetailImgName, String goodsDetailImgPath, String goodsDetailImgUuid) {
        this.id = id;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
    }
}
