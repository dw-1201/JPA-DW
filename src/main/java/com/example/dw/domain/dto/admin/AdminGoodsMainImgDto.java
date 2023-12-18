package com.example.dw.domain.dto.admin;

import lombok.Data;

@Data
public class AdminGoodsMainImgDto {


    private Long id;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private String goodsMainImgName;
    private Long goodsId;

    public AdminGoodsMainImgDto(Long id, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName, Long goodsId) {
        this.id = id;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsId=goodsId;
    }
}
