package com.example.dw.repository.goods;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.dw.domain.entity.goods.QGoods.goods;
import static com.example.dw.domain.entity.goods.QGoodsDetailImg.goodsDetailImg;
import static com.example.dw.domain.entity.goods.QGoodsMainImg.goodsMainImg;
import static java.util.stream.Collectors.*;

@Repository
@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<AdminGoodsDto> findGoodsAll(Pageable pageable, SearchForm searchForm) {
        List<AdminGoodsDto> contents = getGoodsList(pageable, searchForm);
        Long count = getCount(searchForm);

        System.out.println("[상품 개수] :"+ count +"개");

        return new PageImpl<>(contents, pageable,count);
    }

    @Override
    public List<AdminGoodsDetailResultDto> findGoodsById(Long id) {

            List<AdminGoodsDetailDto> list = getGoodsDetail(id);

        return
                list.stream().collect(groupingBy(o->new AdminGoodsDetailResultDto(
                        o.getId(),o.getGoodsName(),o.getGoodsQuantity(), o.getGoodsPrice(), o.getGoodsMade(), o.getGoodsCertify(), o.getGoodsDetailContent(),
                        o.getGoodsRegisterDate(), o.getGoodsModifyDate(), o.getGoodsCategory(), o.getGoodsMainImgName(), o.getGoodsMainImgPath(), o.getGoodsMainImgUuid()), mapping(o->new AdminGoodsDetailImgDto(
                                o.getId(), o.getGoodsDetailImgName(), o.getGoodsDetailImgPath(), o.getGoodsDetailImgUuid(), o.getGoodsDetailImgId()),toList())
                        )
                ).entrySet().stream().map(e->new AdminGoodsDetailResultDto(
                        e.getKey().getId(), e.getKey().getGoodsName(), e.getKey().getGoodsQuantity(), e.getKey().getGoodsPrice(), e.getKey().getGoodsMade(), e.getKey().getGoodsCertify(),
                        e.getKey().getGoodsDetailContent(), e.getKey().getGoodsRegisterDate(), e.getKey().getGoodsModifyDate(), e.getKey().getGoodsCategory(),
                        e.getKey().getGoodsMainImgName(),e.getKey().getGoodsMainImgPath(), e.getKey().getGoodsMainImgUuid(), e.getValue())).collect(toList());




//                list.stream()
//                .collect(groupingBy(o -> new AdminGoodsDetailResultDto(o.getId(), o.getGoodsName(), o.getGoodsQuantity(), o.getGoodsPrice(), o.getGoodsMade(),
//                        o.getGoodsCertify(), o.getGoodsDetailContent(), o.getGoodsRegisterDate(), o.getGoodsModifyDate(), o.getGoodsCategory(),
//                        o.getGoodsMainImgName(), o.getGoodsMainImgPath(), o.getGoodsMainImgUuid()), mapping(o-> new AdminGoodsDetailImgDto(o.getId(), o.getGoodsDetailImgName(), o.getGoodsDetailImgPath(), o.getGoodsDetailImgUuid(), o.getGoodsDetailImgId()), toList())
//
//                )).entrySet().stream()
//                .map(e-> new AdminGoodsDetailResultDto(e.getKey().getId(), e.getKey().getGoodsName(), e.getKey().getGoodsQuantity(), e.getKey().getGoodsPrice(), e.getKey().getGoodsMade(), e.getKey().getGoodsCertify(), e.getKey().getGoodsDetailContent(),
//                        e.getKey().getGoodsRegisterDate(), e.getKey().getGoodsModifyDate(), e.getKey().getGoodsCategory(), e.getKey().getGoodsMainImgName(), e.getKey().getGoodsMainImgPath(), e.getKey().getGoodsMainImgUuid(), e.getValue()))
//                .collect(toList());


    }


    private Long getCount(SearchForm searchForm){
        Long count = jpaQueryFactory
                .select(goods.count())
                .from(goods)
                .where(
                        cateGoryNameEq(searchForm),
                        goodsNameEq(searchForm)
                )
                .fetchOne();
        return count;
    }
    //상품 리스트 조회
    private List<AdminGoodsDto> getGoodsList(Pageable pageable, SearchForm searchForm){

        List<AdminGoodsDto> content = jpaQueryFactory
                .select(new QAdminGoodsDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goods.goodsCategory.stringValue(),
                        goods.goodsRegisterDate,
                        goods.goodsModifyDate
                ))
                .from(goods)
                .where(
                        cateGoryNameEq(searchForm),
                        goodsNameEq(searchForm)
                )
                .orderBy(goods.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return content;

    }



    //상품상세 조회
    private List<AdminGoodsDetailDto> getGoodsDetail(Long id){
        return jpaQueryFactory
                .select(new QAdminGoodsDetailDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goods.goodsMade,
                        goods.goodsCertify,
                        goods.goodsDetailContent,
                        goods.goodsRegisterDate,
                        goods.goodsModifyDate,
                        goods.goodsCategory.stringValue(),
                        goodsMainImg.id,
                        goodsMainImg.goodsMainImgName,
                        goodsMainImg.goodsMainImgPath,
                goodsMainImg.goodsMainImgUuid,
                goodsDetailImg.id,
                goodsDetailImg.goodsDetailImgName,
                goodsDetailImg.goodsDetailImgPath,
                goodsDetailImg.goodsDetailImgUuid
                ))
                .from(goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .leftJoin(goods.goodsDetailImg, goodsDetailImg)
                .where(goods.id.eq(id))
                .fetch();
    }


    private BooleanExpression cateGoryNameEq(SearchForm searchForm){
        return StringUtils.hasText(searchForm.getCate()) ? goods.goodsCategory.stringValue().eq(searchForm.getCate()) : null;
    }

    private BooleanExpression goodsNameEq(SearchForm searchForm){
        return StringUtils.hasText(searchForm.getKeyword()) ? goods.goodsName.containsIgnoreCase(searchForm.getKeyword()) : null;
    }
}
