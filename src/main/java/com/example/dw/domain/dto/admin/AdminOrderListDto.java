package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminOrderListDto {


    private Long orderListId;
    private Long orderId;
    private Long userId;
    private String userAccount;
    private String orderZipcode;
    private String orderAddress;
    private String orderDetailAddress;
    private String orderUserEmail;
    private String orderUserName;
    private String orderUserPhone;
    private LocalDateTime orderDate;
    private Long goodsId;
    private String goodsName;
    private Integer goodsPrice;
    private Integer goodsQuantity;
    private LocalDateTime payDatetime;

    @QueryProjection
    public AdminOrderListDto(Long orderListId, Long orderId, Long userId, String userAccount, String orderZipcode, String orderAddress, String orderDetailAddress, String orderUserEmail, String orderUserName, String orderUserPhone, LocalDateTime orderDate, Long goodsId, String goodsName, Integer goodsPrice, Integer goodsQuantity, LocalDateTime payDatetime) {
        this.orderListId = orderListId;
        this.orderId = orderId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.orderZipcode = orderZipcode;
        this.orderAddress = orderAddress;
        this.orderDetailAddress = orderDetailAddress;
        this.orderUserEmail = orderUserEmail;
        this.orderUserName = orderUserName;
        this.orderUserPhone = orderUserPhone;
        this.orderDate = orderDate;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsQuantity = goodsQuantity;
        this.payDatetime = payDatetime;
    }
}
