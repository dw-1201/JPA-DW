package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminUserDetailOrderDto {



    private Long orderId;
    private LocalDateTime orderRd;

    @QueryProjection

    public AdminUserDetailOrderDto(Long orderId, LocalDateTime orderRd) {
        this.orderId = orderId;
        this.orderRd = orderRd;
    }
}
