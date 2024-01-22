package com.example.dw.domain.dto.admin.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsMainImg {

    private Long goodsMainImgId;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private String goodsMainImgName;


    public AdminGoodsMainImg(Long goodsMainImgId, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName) {
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsMainImgName = goodsMainImgName;
    }
}
