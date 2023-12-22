package com.example.dw.repository.goods;

import com.example.dw.domain.dto.goods.GoodsDetailDto;
import com.example.dw.domain.dto.goods.GoodsListDto;
import com.example.dw.domain.dto.goods.QGoodsDetailDto;
import com.example.dw.domain.dto.goods.QGoodsListDto;
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

    private Long getCount(SearchForm searchForm){
        Long count = jpaQueryFactory
                .select(goods.count())
                .from(goods)
                .fetchOne();
        return count;
    }



}
