package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminUserDetailOrderResultDto {

    private Long orderId;
    private LocalDateTime orderTime;
    private List<AdminUserDetailPaymentListDto> orderItems;

    @QueryProjection
    public AdminUserDetailOrderResultDto(Long orderId, LocalDateTime orderTime) {
        this.orderId = orderId;
        this.orderTime = orderTime;
    }

    public AdminUserDetailOrderResultDto(Long orderId, LocalDateTime orderTime, List<AdminUserDetailPaymentListDto> orderItems) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderItems = orderItems;
    }
}
