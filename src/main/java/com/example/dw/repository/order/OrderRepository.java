package com.example.dw.repository.order;

import com.example.dw.domain.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
