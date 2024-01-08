package com.example.dw.repository.goods;

import com.example.dw.domain.dto.goods.GoodsPickListDto;
import com.example.dw.domain.dto.goods.QGoodsPickListDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.goods.QGoods.goods;
import static com.example.dw.domain.entity.goods.QGoodsPayList.goodsPayList;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class GoodsPayListRepositoryImpl implements GoodsPayListRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<GoodsPickListDto> findGoodPayListIdByUserId(Long userId){
        List<GoodsPickListDto> contents = jpaQueryFactory
                .select(new QGoodsPickListDto(
                        goodsPayList.id,
                        goodsPayList.goodsQuantity,
                        goodsPayList.goodsPrice,
                        goods.id,
                        goods.goodsName,
                        users.id
                ))
                .from(goodsPayList)
                .leftJoin(goodsPayList.goods, goods)
                .leftJoin(goodsPayList.users, users)
                .where(goodsPayList.users.id.eq(userId).or(goodsPayList.users.isNull()))
                .fetch();



        return contents;
    }
}
