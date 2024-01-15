package com.example.dw.domain.dto.order;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class OrderListResultDto {


    //주문서 id
    private Long id;
    //주문서 등록 날짜
    private LocalDateTime orderDate;

    private Long userId;

    private List<OrderItemDto> orderItemDtoList;


    @QueryProjection
    public OrderListResultDto(Long id, LocalDateTime orderDate, Long userId, List<OrderItemDto> orderItemDtoList) {
        this.id = id;
        this.orderDate = orderDate;
        this.userId = userId;
        this.orderItemDtoList = orderItemDtoList;
    }
}
