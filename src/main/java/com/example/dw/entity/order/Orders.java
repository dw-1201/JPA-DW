package com.example.dw.entity.order;


import com.example.dw.entity.goods.Goods;
import com.example.dw.entity.user.Users;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
@Getter
@Setter
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

//    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    private List<Cart> cartList = new ArrayList<>();

//    @OneToOne(fetch =FetchType.LAZY)
//    private Goods goods;

    @OneToOne(mappedBy = "orders",fetch = FetchType.LAZY)
    private OrderList orderList;

}
