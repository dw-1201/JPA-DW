package com.example.dw.domain.dto.order;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class OrderDto {

    private Long id;
    private LocalDateTime orderRegisterDate;
    private Long userId;

    @QueryProjection
    public OrderDto(Long id, LocalDateTime orderRegisterDate, Long userId) {
        this.id = id;
        this.orderRegisterDate = orderRegisterDate;
        this.userId = userId;
    }
}
