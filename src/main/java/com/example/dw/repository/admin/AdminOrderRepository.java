package com.example.dw.repository.admin;

import com.example.dw.domain.entity.order.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminOrderRepository extends JpaRepository<Orders, Long> {
}
