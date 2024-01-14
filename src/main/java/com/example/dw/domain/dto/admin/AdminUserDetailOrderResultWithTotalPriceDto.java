package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class AdminUserDetailOrderResultWithTotalPriceDto {


    private Integer totalPrice;
    private List<AdminUserDetailOrderResultDto> orders;


    public AdminUserDetailOrderResultWithTotalPriceDto(Integer totalPrice, List<AdminUserDetailOrderResultDto> orders) {
        this.totalPrice = totalPrice;
        this.orders = orders;
    }

    public void setList(Integer totalPrice ,List<AdminUserDetailOrderResultDto> orders){
        this.totalPrice=totalPrice;
        this.orders=orders;

    }

}
