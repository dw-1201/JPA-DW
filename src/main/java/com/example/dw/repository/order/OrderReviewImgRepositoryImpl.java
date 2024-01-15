package com.example.dw.repository.order;


import com.example.dw.domain.dto.order.OrderReviewImgDto;
import com.example.dw.domain.dto.order.QOrderReviewImgDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.order.QOrderReviewImg.orderReviewImg;
import static com.example.dw.domain.entity.order.QOrderReview.orderReview;

@Repository
@RequiredArgsConstructor
public class OrderReviewImgRepositoryImpl implements OrderReviewImgRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;



    @Override
    public List<OrderReviewImgDto> findReviewImgById(Long id) {

        List<OrderReviewImgDto> imgDto = jpaQueryFactory
                .select(new QOrderReviewImgDto(
                        orderReviewImg.id,
                        orderReview.id,
                        orderReviewImg.reviewimgFileName,
                        orderReviewImg.reviewimgPath,
                        orderReviewImg.reviewimgUuid
                ))
                .from(orderReviewImg)
                .where(orderReview.id.eq(id))
                .fetch();

        return imgDto;

    }
}
