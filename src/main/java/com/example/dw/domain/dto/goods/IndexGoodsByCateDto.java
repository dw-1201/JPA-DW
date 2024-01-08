package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IndexGoodsByCateDto {

    private Long goodsId;
    private String goodsName;
    private Integer goodsPrice;
    private String goodsCate;
    private Long goodsImgId;
    private String goodsImgPath;
    private String goodsImgUuid;
    private String goodsImgName;


    @QueryProjection
    public IndexGoodsByCateDto(Long goodsId, String goodsName, Integer goodsPrice, String goodsCate, Long goodsImgId, String goodsImgPath, String goodsImgUuid, String goodsImgName) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsCate = goodsCate;
        this.goodsImgId = goodsImgId;
        this.goodsImgPath = goodsImgPath;
        this.goodsImgUuid = goodsImgUuid;
        this.goodsImgName = goodsImgName;
    }
}
