package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsReviewMainImgDto {

    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private String goodsMainImgName;


    public AdminGoodsReviewMainImgDto(String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName) {
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsMainImgName = goodsMainImgName;
    }
}
