package com.example.dw.repository.order;

import com.example.dw.domain.entity.order.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList, Long> {
}
