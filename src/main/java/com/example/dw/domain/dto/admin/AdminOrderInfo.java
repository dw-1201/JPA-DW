package com.example.dw.domain.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminOrderInfo {

    private Long orderId;
    private Long userId;
    private String userAccount;
    private String orderZipcode;
    private String orderAddress;
    private String orderDetailAddress;
    private String orderUserEmail;
    private String orderUserName;
    private String orderUserPhone;
    private LocalDateTime orderDate;
    private List<AdminOrderItem> adminOrderItems;


    public AdminOrderInfo(Long orderId, Long userId, String userAccount, String orderZipcode, String orderAddress, String orderDetailAddress, String orderUserEmail, String orderUserName, String orderUserPhone, LocalDateTime orderDate, List<AdminOrderItem> adminOrderItems) {
        this.orderId = orderId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.orderZipcode = orderZipcode;
        this.orderAddress = orderAddress;
        this.orderDetailAddress = orderDetailAddress;
        this.orderUserEmail = orderUserEmail;
        this.orderUserName = orderUserName;
        this.orderUserPhone = orderUserPhone;
        this.orderDate = orderDate;
        this.adminOrderItems = adminOrderItems;
    }
}
