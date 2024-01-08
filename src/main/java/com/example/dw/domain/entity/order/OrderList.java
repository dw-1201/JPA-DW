package com.example.dw.domain.entity.order;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Getter
@Table(name="order_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderList {

    @Id
    @GeneratedValue
    @Column(name = "order_list_id")
    private Long id;

    @CreatedDate
    private String orderDate;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Orders orders;

    @OneToOne(mappedBy = "orderList",fetch = FetchType.LAZY)
    private OrderReview orderReview;

    @Builder
    public OrderList(Long id, String orderDate, Orders orders, OrderReview orderReview) {
        this.id = id;
        this.orderDate = orderDate;
        this.orders = orders;
        this.orderReview = orderReview;
    }

    @PrePersist
    public void onPrePersist(){
        this.orderDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }
}
