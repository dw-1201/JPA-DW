package com.example.dw.domain.entity.order;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="order_list")
public class OrderList {

    @Id
    @GeneratedValue
    @Column(name = "order_list_id")
    private Long id;

    private LocalDateTime orderDate;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orders;

    @OneToOne(mappedBy = "orderList",fetch = FetchType.LAZY)
    private OrderReview orderReview;

}