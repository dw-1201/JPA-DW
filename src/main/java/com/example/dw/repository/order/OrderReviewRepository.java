package com.example.dw.repository.order;

import com.example.dw.domain.entity.order.OrderReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderReviewRepository extends JpaRepository<OrderReview,Long> {

    @Query("select or.orderItem.id from OrderReview or where or.id = :id")
    Long reviewId(@Param("id") Long Id);



}
