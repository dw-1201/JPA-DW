package com.example.dw.domain.entity.order;


import com.example.dw.domain.entity.user.Users;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Orders {
    @Id
    @GeneratedValue
    @Column(name="order_id")
    private Long id;

    private String orderUserName;
    private String orderUserAddressNumber;
    private String orderAddressNormal;
    private String orderAddressDetail;
    private String orderUserPhoneNumber;
    private String orderUserEmail;
    @Nullable
    private String orderMemo;

    @ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToOne(mappedBy = "orders",fetch = FetchType.LAZY)
    private OrderList orderList;

    @Builder
    public Orders(Long id, String orderUserName, String orderUserAddressNumber, String orderAddressNormal, String orderAddressDetail, String orderUserPhoneNumber, String orderUserEmail, String orderMemo, Users user, OrderList orderList) {
        this.id = id;
        this.orderUserName = orderUserName;
        this.orderUserAddressNumber = orderUserAddressNumber;
        this.orderAddressNormal = orderAddressNormal;
        this.orderAddressDetail = orderAddressDetail;
        this.orderUserPhoneNumber = orderUserPhoneNumber;
        this.orderUserEmail = orderUserEmail;
        this.orderMemo = orderMemo;
        this.user = user;
        this.orderList = orderList;
    }
}
