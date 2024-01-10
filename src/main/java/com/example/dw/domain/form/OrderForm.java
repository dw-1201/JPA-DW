package com.example.dw.domain.form;

import com.example.dw.domain.entity.order.Orders;
import com.example.dw.domain.entity.user.Users;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderForm {

    private Long id;
    private String orderUserName;
    private String orderUserAddressNumber;
    private String orderAddressNormal;
    private String orderAddressDetail;
    private String orderAddressDetails;
    private String orderUserPhoneNumber;
    private String orderUserEmail;
    private String orderMemo;
    //회원Id
    private Long userId;

    public Orders toEntity(){
        return Orders.builder()
                .id(id)
                .orderUserName(orderUserName)
                .orderUserAddressNumber(orderUserAddressNumber)
                .orderAddressNormal(orderAddressNormal)
                .orderAddressDetail(orderAddressDetail)
                .orderAddressDetails(orderAddressDetails)
                .orderUserPhoneNumber(orderUserPhoneNumber)
                .orderUserEmail(orderUserEmail)
                .orderMemo(orderMemo)
                .users(Users.builder().id(userId).build())
                .build();
    }

    @Builder
    public OrderForm(Long id, String orderUserName, String orderUserAddressNumber, String orderAddressNormal, String orderAddressDetail, String orderAddressDetails, String orderUserPhoneNumber, String orderUserEmail, String orderMemo, Long userId) {
        this.id = id;
        this.orderUserName = orderUserName;
        this.orderUserAddressNumber = orderUserAddressNumber;
        this.orderAddressNormal = orderAddressNormal;
        this.orderAddressDetail = orderAddressDetail;
        this.orderAddressDetails = orderAddressDetails;
        this.orderUserPhoneNumber = orderUserPhoneNumber;
        this.orderUserEmail = orderUserEmail;
        this.orderMemo = orderMemo;
        this.userId = userId;
    }
}
