package com.example.dw.repository.order;


import com.example.dw.domain.dto.order.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.dw.domain.entity.goods.QGoodsMainImg.goodsMainImg;
import static com.example.dw.domain.entity.order.QOrderItem.orderItem;
import static com.example.dw.domain.entity.order.QOrderReview.orderReview;
import static com.example.dw.domain.entity.order.QOrders.orders;
import static com.example.dw.domain.entity.user.QUsers.users;
import static java.util.stream.Collectors.toList;

@Repository
@RequiredArgsConstructor
public class OrderListRepositoryImpl implements OrderListRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<OrderListResultDto> findAllbyId(Pageable pageable, Long userId) {


        List<OrderDto> content = jpaQueryFactory
                .select(new QOrderDto(
                        orders.id,
                        orders.orderRegisterDate,
                        users.id
                ))
                .from(orders)
                .leftJoin(orders.user,users)
                .where(orders.user.id.eq(userId))
                .fetch();


        List<OrderListResultDto> result =
                content.stream().map(orderDto -> {

                    List<OrderItemDto> orderItemDtos = jpaQueryFactory
                            .select(new QOrderItemDto(
                                    orderItem.id,
                                    orderItem.orderQuantity,
                                    orderItem.orderPrice,
                                    orderItem.goods.id,
                                    orderItem.goods.goodsName,
                                    goodsMainImg.id,
                                    goodsMainImg.goodsMainImgName,
                                    goodsMainImg.goodsMainImgPath,
                                    goodsMainImg.goodsMainImgUuid,
                                    orderItem.orderReview.id,
                                    orderItem.orderReview.state
                            ))
                            .from(orderItem)
                            .leftJoin(orderItem.goods.goodsMainImg,goodsMainImg)
                            .leftJoin(orderItem.orderReview,orderReview)
                            .where(orderItem.orders.id.eq(orderDto.getId()))
                            .fetch();

                        List<OrderItemDto> orderItemDtoList = orderItemDtos.stream().map(
                                orderItemDtoLists -> new OrderItemDto(
                                        orderItemDtoLists.getId(),
                                        orderItemDtoLists.getOrderQuantity(),
                                        orderItemDtoLists.getOrderPrice(),
                                        orderItemDtoLists.getGoodsid(),
                                        orderItemDtoLists.getGoodsName(),
                                        orderItemDtoLists.getGoodsMainImgId(),
                                        orderItemDtoLists.getGoodsMainImgName(),
                                        orderItemDtoLists.getGoodsMainImgPath(),
                                        orderItemDtoLists.getGoodsMainImgUuid(),
                                        orderItemDtoLists.getOrderReviewId(),
                                        orderItemDtoLists.getState()
                                )).collect(toList());

                        return new OrderListResultDto(
                                orderDto.getId(),
                                orderDto.getOrderRegisterDate(),
                                orderDto.getUserId(),
                                orderItemDtoList
                        );

                }).collect(toList());


        Long counts = jpaQueryFactory
                .select(orders.count())
                .from(orders)
                .where(orders.user.id.eq(userId))
                .fetchOne();



        result.forEach(r -> System.out.println(r +"입니다."));


        return new PageImpl<>(result, pageable,counts);

    }
}
