package com.example.dw.domain.entity.order;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="order_list")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class OrderList {

    @Id
    @GeneratedValue
    @Column(name = "order_list_id")
    private Long id;

    @CreatedDate
    private LocalDateTime orderDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders orders;

    @Builder
    public OrderList(Long id, LocalDateTime orderDate, Orders orders) {
        this.id = id;
        this.orderDate = orderDate;
        this.orders = orders;
    }
}
