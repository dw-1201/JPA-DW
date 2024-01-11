package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminOrderDetailResultDto {

    private Long orderId;
    private AdminOrderDetailDto adminOrderDetailDto;


    public AdminOrderDetailResultDto(Long orderId, AdminOrderDetailDto adminOrderDetailDto) {
        this.orderId = orderId;
        this.adminOrderDetailDto = adminOrderDetailDto;
    }
}
