//package com.example.dw.domain.dto.order;
//
//import com.querydsl.core.annotations.QueryProjection;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
////주문서와 상품을 조회해서 주문서 아이템에 넣기 위한 Dto
//@Data
//@NoArgsConstructor
//public class OrderItemDto {
//
//    private Long id;
//    private Long orderId;
//    private Long goodsId;
//    private Long goodsQuantity;
//    private Long goodsPrice;
//
//    @QueryProjection
//    public OrderItemDto(Long orderId, Long goodsId, Long goodsQuantity, Long goodsPrice) {
//        this.orderId = orderId;
//        this.goodsId = goodsId;
//        this.goodsQuantity = goodsQuantity;
//        this.goodsPrice = goodsPrice;
//    }
//}
