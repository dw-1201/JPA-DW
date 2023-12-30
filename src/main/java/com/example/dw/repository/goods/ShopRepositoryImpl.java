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
import java.util.Optional;

import static com.example.dw.domain.entity.goods.QCartItem.cartItem;
import static com.example.dw.domain.entity.goods.QCart.cart;
import static com.example.dw.domain.entity.goods.QGoods.goods;
import static com.example.dw.domain.entity.goods.QGoodsDetailImg.goodsDetailImg;
import static com.example.dw.domain.entity.goods.QGoodsMainImg.goodsMainImg;
import static com.example.dw.domain.entity.goods.QGoodsQue.goodsQue;
import static com.example.dw.domain.entity.goods.QGoodsQueReply.goodsQueReply;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class ShopRepositoryImpl implements ShopRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<GoodsDetailImgDto> findGoodsDetailImg(Long goodsId) {
        return jpaQueryFactory.select(new QGoodsDetailImgDto(
                goodsDetailImg.id,
                goodsDetailImg.goodsDetailImgName,
                goodsDetailImg.goodsDetailImgPath,
                goodsDetailImg.goodsDetailImgUuid
        ))
                .from(goodsDetailImg)
                .where(goodsDetailImg.goods.id.eq(goodsId))
                .fetch();
    }



    @Override
    public CartDto findCartIdByUserId(Long userId) {
        CartDto cartDto = jpaQueryFactory.select(new QCartDto(
                cart.id,
                cart.users.id
        ))
                .from(cart)
                .leftJoin(cart.users, users)
                .where(cart.users.id.eq(userId))
                .fetchOne();
        return cartDto;
    }

    //장바구니 아이템으로 들어가기 위해 id체크
    @Override
    public boolean checkGoodsId(Long goodsId, Long userId, Long cartId) {
        CartItemCheckDto check =
         jpaQueryFactory.select(new QCartItemCheckDto(
                cartItem.id,
                cartItem.goods.id,
                cartItem.cart.id,
                cartItem.cart.users.id
        ))
                .from(cartItem)
                .leftJoin(cartItem.goods, goods)
                .leftJoin(cartItem.cart, cart)
                .leftJoin(cart.users, users)
                .where(cartItem.goods.id.eq(goodsId))
                .fetchOne();

        if(check==null){
            return false;
        }else if(check.getGoodsId()==goodsId){
            return true;
        }else{
            return false;
        }

    }

    //카트 아이템 조회
    @Override
    public List<GoodsCartItemDto> findGoodsCartItemById(Long cartId, Long userId) {
        List<GoodsCartItemDto> contents = jpaQueryFactory
                .select(new QGoodsCartItemDto(
                        cartItem.id,
                        cart.id,
                        cart.users.id,
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goodsMainImg.id,
                        goodsMainImg.goodsMainImgName,
                        goodsMainImg.goodsMainImgPath,
                        goodsMainImg.goodsMainImgUuid
                ))
                .from(cartItem)
                .leftJoin(cartItem.goods, goods)
                .leftJoin(cartItem.goods.goodsMainImg, goodsMainImg)
                .leftJoin(cartItem.cart, cart)
                .leftJoin(cart.users, users)
                .where(cart.id.eq(cartId).and(
                        cart.users.id.eq(userId)
                ))
                .fetch();

        return contents;
    }


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
    public Optional<GoodsDetailDto> findGoodsById(Long id){
        return Optional.ofNullable(jpaQueryFactory
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
                .fetchOne());
    }

    @Override
    public Optional<GoodsAddInfoDto> findGoodsAddInfoById(Long id) {
        return Optional.ofNullable(jpaQueryFactory
                .select(new QGoodsAddInfoDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsMade,
                        goods.goodsCertify
                ))
                .from(goods)
                .where(goods.id.eq(id))
                .fetchOne()
        );
    }

    @Override
    public List<GoodsQueDto> findGoodsQueId(Long id) {
        List<GoodsQueDto> contents = jpaQueryFactory
                .select(new QGoodsQueDto(
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
                .leftJoin(goods.goodsQues, goodsQue)
                .leftJoin(goodsQue.goodsQueReply, goodsQueReply)
                .leftJoin(goodsQue.users, users)
                .where(goods.id.eq(id))
                .orderBy(goodsQue.id.desc())
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
