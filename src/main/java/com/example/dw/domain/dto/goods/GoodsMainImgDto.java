package com.example.dw.domain.dto.goods;

import lombok.Data;

@Data
public class GoodsMainImgDto {

    private Long id;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private String goodsMainImgName;

    public GoodsMainImgDto(Long id, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName) {
        this.id = id;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsMainImgName = goodsMainImgName;
    }
}
