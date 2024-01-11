package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminOrderDetailGoodsListDto {

    //주문 상품 정보
    private Long orderGoodsId;
    private String orderGoodsName;
    private Integer orderGoodsQuantity;
    private Integer orderGoodsPrice;
    private String orderGoodsMainImgPath;
    private String orderGoodsMainImgUuid;
    private String orderGoodsMainImgName;

    @QueryProjection
    public AdminOrderDetailGoodsListDto(Long orderGoodsId, String orderGoodsName, Integer orderGoodsQuantity, Integer orderGoodsPrice, String orderGoodsMainImgPath, String orderGoodsMainImgUuid, String orderGoodsMainImgName) {
        this.orderGoodsId = orderGoodsId;
        this.orderGoodsName = orderGoodsName;
        this.orderGoodsQuantity = orderGoodsQuantity;
        this.orderGoodsPrice = orderGoodsPrice;
        this.orderGoodsMainImgPath = orderGoodsMainImgPath;
        this.orderGoodsMainImgUuid = orderGoodsMainImgUuid;
        this.orderGoodsMainImgName = orderGoodsMainImgName;
    }
}
