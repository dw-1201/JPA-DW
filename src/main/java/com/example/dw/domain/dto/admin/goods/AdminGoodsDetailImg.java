package com.example.dw.domain.dto.admin.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminGoodsDetailImg {

    private Long goodsDetailImgId;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;
    private String goodsDetailImgName;

    public AdminGoodsDetailImg(Long goodsDetailImgId, String goodsDetailImgPath, String goodsDetailImgUuid, String goodsDetailImgName) {
        this.goodsDetailImgId = goodsDetailImgId;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
        this.goodsDetailImgName = goodsDetailImgName;
    }
}
