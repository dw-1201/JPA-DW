package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminUserDetailOrderResultDto {

    private Long orderId;
    private LocalDateTime orderTime;
    List<AdminUserDetailPaymentGoodsDto> orderGoodsList;


    public AdminUserDetailOrderResultDto(Long orderId, LocalDateTime orderTime) {
        this.orderId = orderId;
        this.orderTime = orderTime;
    }

    public AdminUserDetailOrderResultDto(Long orderId, LocalDateTime orderTime, List<AdminUserDetailPaymentGoodsDto> orderGoodsList) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderGoodsList = orderGoodsList;
    }
}
