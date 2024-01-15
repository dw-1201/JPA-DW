package com.example.dw.repository.order;

import com.example.dw.domain.entity.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


    @Modifying
    @Query("update OrderItem oi set oi.state =1 where oi.id=:orderItemId")
    void updatrorderreview(@Param("orderItemId") Long id);

    @Modifying
    @Query("update OrderItem oi set oi.state =0 where oi.id=:orderItemId")
    void downorderreview(@Param("orderItemId") Long id);
}
