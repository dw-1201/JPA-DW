package com.example.dw.repository.order;

import com.example.dw.domain.dto.order.OrderItemDto;
import com.example.dw.domain.dto.order.QOrderItemDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.dw.domain.entity.order.QOrderItem.orderItem;
import static com.example.dw.domain.entity.goods.QGoodsMainImg.goodsMainImg;
import static com.example.dw.domain.entity.order.QOrderReview.orderReview;
import static com.example.dw.domain.entity.goods.QGoods.goods;


@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImp implements OrderItemRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;


}
