package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

//상품 추가정보 조회 DTO
@Data
public class GoodsInfoDto {

    //상품 추가정보
    private Long id;
    private String goodsName;
    private String goodsMade; //제조죽
    private String goodsCertify; //인증허가

    @QueryProjection
    public GoodsInfoDto(Long id, String goodsName, String goodsMade,
                        String goodsCertify) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsMade = goodsMade;
        this.goodsCertify = goodsCertify;
    }
}


