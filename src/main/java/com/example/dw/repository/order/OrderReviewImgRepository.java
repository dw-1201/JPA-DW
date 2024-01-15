package com.example.dw.repository.order;

import com.example.dw.domain.entity.order.OrderReviewImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderReviewImgRepository extends JpaRepository<OrderReviewImg,Long> {

    void deleteById(Long id);


}
