package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminUserDetailOrderResultWithTotalPriceDto {


    private Integer totalPrice;
    private List<AdminUserDetailOrderResultDto> orderList;


    public AdminUserDetailOrderResultWithTotalPriceDto(Integer totalPrice, List<AdminUserDetailOrderResultDto> orderList) {
        this.totalPrice = totalPrice;
        this.orderList = orderList;
    }
}
