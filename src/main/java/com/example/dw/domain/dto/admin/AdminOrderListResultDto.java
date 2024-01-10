package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminOrderListResultDto {

    private Long orderListId;
    private LocalDateTime payDatetime;
    private AdminOrderInfo adminOrderInfo;



    public AdminOrderListResultDto(Long orderListId, LocalDateTime payDatetime, AdminOrderInfo adminOrderInfo) {
        this.orderListId = orderListId;
        this.payDatetime = payDatetime;
        this.adminOrderInfo = adminOrderInfo;
    }
}
