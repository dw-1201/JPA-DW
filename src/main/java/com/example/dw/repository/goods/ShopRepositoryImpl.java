package com.example.dw.repository.goods;

import com.example.dw.domain.dto.goods.*;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.goods.QGoods.goods;
import static com.example.dw.domain.entity.goods.QGoodsMainImg.goodsMainImg;
import static com.example.dw.domain.entity.goods.QGoodsQue.goodsQue;
import static com.example.dw.domain.entity.goods.QGoodsQueReply.goodsQueReply;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class ShopRepositoryImpl implements ShopRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<GoodsListDto> findGoodsListAll(Pageable pageable, SearchForm searchForm) {
        List<GoodsListDto> contents = getShopGoodsList(pageable, searchForm);
        Long count = getCount(searchForm);

        System.out.println("[상품 개수] :"+ count +"개");

        return new PageImpl<>(contents, pageable,count);
    }

    //쇼핑 상품 리스트 조회
    private List<GoodsListDto> getShopGoodsList(Pageable pageable, SearchForm searchForm){
        List<GoodsListDto> content = jpaQueryFactory
                .select(new QGoodsListDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goods.goodsMade,
                        goods.goodsRegisterDate,
                        goods.goodsModifyDate,
                        goods.goodsCategory.stringValue(),
                        goodsMainImg.id,
                        goodsMainImg.goodsMainImgName,
                        goodsMainImg.goodsMainImgPath,
                        goodsMainImg.goodsMainImgUuid
                ))
                .from(goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .orderBy(goods.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        content.stream().forEach(r->{
            System.out.println(r.getId()+"=====================");
        });

        return  content;
    }

    //쇼핑 상품 상세 조회
    @Override
    public List<GoodsDetailDto> findGoodsById(Long id){
        return jpaQueryFactory
                .select(new QGoodsDetailDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goods.goodsMade,
                        goods.goodsDetailContent,
                        goods.goodsRegisterDate,
                        goods.goodsModifyDate,
                        goods.goodsCategory.stringValue(),
                        goodsMainImg.id,
                        goodsMainImg.goodsMainImgName,
                        goodsMainImg.goodsMainImgPath,
                        goodsMainImg.goodsMainImgUuid
                ))
                .from(goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .where(goods.id.eq(id))
                .fetch();
    }

    @Override
    public List<GoodsQueDto> findGoodsQueId(Long id) {
        List<GoodsQueDto> contents = jpaQueryFactory
                .select(new QGoodsQueDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goods.goodsMade,
                        goods.goodsDetailContent,
                        goods.goodsRegisterDate,
                        goods.goodsModifyDate,
                        goods.goodsCategory.stringValue(),
                        goodsMainImg.id,
                        goodsMainImg.goodsMainImgName,
                        goodsMainImg.goodsMainImgPath,
                        goodsMainImg.goodsMainImgUuid,
                        goodsQue.id,
                        goodsQue.queContent,
                        goodsQue.queRegisterDate,
                        goodsQue.queModifyDate,
                        goodsQueReply.id,
                        goodsQueReply.queReplyContent,
                        goodsQueReply.queReplyRegisterDate,
                        goodsQueReply.queReplyModifyDate,
                        users.id,
                        users.userAccount,
                        users.userNickName
                ))
                .from(goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .leftJoin(goods.goodsQues, goodsQue)
                .leftJoin(goodsQue.goodsQueReply, goodsQueReply)
                .leftJoin(goodsQue.users, users)
                .where(goods.id.eq(id))
                .orderBy(goods.id.desc())
                .fetch();

        contents.forEach(r -> System.out.println(r.getId() + "====================="));

        return contents;
    }


    private Long getCount(SearchForm searchForm){
        Long count = jpaQueryFactory
                .select(goods.count())
                .from(goods)
                .fetchOne();
        return count;
    }



}
