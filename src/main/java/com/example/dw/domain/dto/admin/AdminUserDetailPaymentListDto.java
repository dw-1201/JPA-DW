package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminUserDetailPaymentListDto {

    private Long goodsId;
    private String goodsName;
    private Integer orderQuantity;
    private Integer orderPrice;


    @QueryProjection

    public AdminUserDetailPaymentListDto(Long goodsId, String goodsName, Integer orderQuantity, Integer orderPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.orderQuantity = orderQuantity;
        this.orderPrice = orderPrice;
    }
}
