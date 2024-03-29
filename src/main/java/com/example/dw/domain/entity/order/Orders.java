package com.example.dw.domain.entity.order;


import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@EntityListeners(AuditingEntityListener.class)
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
    private String orderAddressDetails;
    private String orderUserPhoneNumber;
    private String orderUserEmail;
    private String orderMemo;

    @CreatedDate
    private LocalDateTime orderRegisterDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @OneToOne(mappedBy = "orders",fetch = FetchType.LAZY)
    private OrderList orderList;

    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<OrderItem> orderItems=new ArrayList<>();



    @Builder
    public Orders(Long id, String orderUserName, String orderUserAddressNumber, String orderAddressNormal, String orderAddressDetail, String orderAddressDetails, String orderUserPhoneNumber, String orderUserEmail, String orderMemo, LocalDateTime orderRegisterDate, Users users, OrderList orderList, List<OrderItem> orderItems) {
        this.id = id;
        this.orderUserName = orderUserName;
        this.orderUserAddressNumber = orderUserAddressNumber;
        this.orderAddressNormal = orderAddressNormal;
        this.orderAddressDetail = orderAddressDetail;
        this.orderAddressDetails = orderAddressDetails;
        this.orderUserPhoneNumber = orderUserPhoneNumber;
        this.orderUserEmail = orderUserEmail;
        this.orderMemo = orderMemo;
        this.orderRegisterDate = orderRegisterDate;
        this.users = users;
        this.orderList = orderList;
        this.orderItems = orderItems;
    }
}
