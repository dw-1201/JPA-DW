package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminOrderDetailDto {

        private Long userId;
        private String orderAccount;
        private String orderUserName;
        private String oderEmail;
        private String orderPhone;
        private String orderZipcode;
        private String orderAddress;
        private String orderAddressDetail;
        private String orderMemo;
        private LocalDateTime orderDate;

        private List<AdminOrderDetailGoodsListDto> adminOrderDetailGoodsListDtoList;

    @QueryProjection
    public AdminOrderDetailDto(Long userId, String orderAccount, String orderUserName, String oderEmail, String orderPhone, String orderZipcode, String orderAddress, String orderAddressDetail, String orderMemo, LocalDateTime orderDate) {
        this.userId = userId;
        this.orderAccount = orderAccount;
        this.orderUserName = orderUserName;
        this.oderEmail = oderEmail;
        this.orderPhone = orderPhone;
        this.orderZipcode = orderZipcode;
        this.orderAddress = orderAddress;
        this.orderAddressDetail = orderAddressDetail;
        this.orderMemo = orderMemo;
        this.orderDate = orderDate;
    }





    public AdminOrderDetailDto(Long userId, String orderAccount, String orderUserName, String oderEmail, String orderPhone, String orderZipcode, String orderAddress, String orderAddressDetail, String orderMemo, LocalDateTime orderDate, List<AdminOrderDetailGoodsListDto> adminOrderDetailGoodsListDtoList) {
        this.userId = userId;
        this.orderAccount = orderAccount;
        this.orderUserName = orderUserName;
        this.oderEmail = oderEmail;
        this.orderPhone = orderPhone;
        this.orderZipcode = orderZipcode;
        this.orderAddress = orderAddress;
        this.orderAddressDetail = orderAddressDetail;
        this.orderMemo = orderMemo;
        this.orderDate = orderDate;
        this.adminOrderDetailGoodsListDtoList = adminOrderDetailGoodsListDtoList;
    }








}
