package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

//상품 서브(설명)이미지 조회 DTO
@Data
public class GoodsDetailImgDto {

    //상품 서브 이미지
    private Long goodsDetailImgId;
    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;

    @QueryProjection

    public GoodsDetailImgDto(Long goodsDetailImgId, String goodsDetailImgName,
                             String goodsDetailImgPath, String goodsDetailImgUuid) {
        this.goodsDetailImgId = goodsDetailImgId;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
    }
}


