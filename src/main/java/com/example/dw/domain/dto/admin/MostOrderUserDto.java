package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MostOrderUserDto {

    private Long userId;
    private String userAccount;
    private String userName;
    private Long totalOrderCount;
    private Integer totalPrice;



    @QueryProjection
    public MostOrderUserDto(Long userId, String userAccount, String userName) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userName = userName;
    }


    public MostOrderUserDto(Long userId, String userAccount, String userName, Long totalOrderCount, Integer totalPrice) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userName = userName;
        this.totalOrderCount = totalOrderCount;
        this.totalPrice = totalPrice;
    }
}
