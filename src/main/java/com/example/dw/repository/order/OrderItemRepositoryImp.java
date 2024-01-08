package com.example.dw.repository.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
@Repository
@RequiredArgsConstructor
public class OrderItemRepositoryImp implements OrderItemRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

//    @Override
//    public List<OrderItemDto> findOrderItemAll(Long userId) {
//        List<OrderItemDto> contents = jpaQueryFactory
//                .select(new QOrderItemDto(
//                        orders.id,
//                        goods.id,
//                        goods.goodsQuantity,
//                        goods.goodsPrice
//                ))
//                .from(orders)
//                .leftJoin(orders.goods, goods)
//                .where(orders.user.id.eq(userId))
//                .fetch();
//        return contents;
//    }
}
