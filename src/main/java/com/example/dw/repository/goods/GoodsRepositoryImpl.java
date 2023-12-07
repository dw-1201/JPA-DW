package com.example.dw.repository.goods;

import com.example.dw.domain.dto.admin.GoodsDto;
import com.example.dw.domain.dto.admin.QGoodsDto;
import com.example.dw.domain.dto.goods.GoodsDetailDto;
import com.example.dw.domain.dto.goods.GoodsDetailImgDto;
import com.example.dw.domain.dto.goods.GoodsDetailResultDto;
import com.example.dw.domain.dto.goods.QGoodsDetailDto;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.dw.domain.entity.goods.QGoods.goods;
import static com.example.dw.domain.entity.goods.QGoodsDetailImg.goodsDetailImg;
import static java.util.stream.Collectors.*;

@Repository
@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<GoodsDto> findGoodsAll(Pageable pageable, SearchForm searchForm) {
        List<GoodsDto> contents = getGoodsList(pageable, searchForm);
        Long count = getCount(searchForm);
        return new PageImpl<>(contents, pageable,count);
    }

    @Override
    public Optional<GoodsDetailResultDto> findGoodsById(Long id) {

            List<GoodsDetailDto> list = getGoodsDetail(id);

        return Optional.ofNullable(list.stream()
                .collect(groupingBy(o -> new GoodsDetailResultDto(o.getId(), o.getGoodsName(), o.getGoodsQuantity(), o.getGoodsPrice(), o.getGoodsMade(),
                        o.getGoodsCertify(), o.getGoodsDetailContent(), o.getGoodsRegisterDate(), o.getGoodsModifyDate(), o.getGoodsCategory(),
                        o.getGoodsMainImgName(), o.getGoodsMainImgPath(), o.getGoodsMainImgUuid()), mapping(o-> new GoodsDetailImgDto(o.getId(), o.getGoodsDetailImgName(), o.getGoodsDetailImgPath(), o.getGoodsDetailImgUuid()), toList())

                )).entrySet().stream()
                .map(e-> new GoodsDetailResultDto(e.getKey().getId(), e.getKey().getGoodsName(), e.getKey().getGoodsQuantity(), e.getKey().getGoodsPrice(), e.getKey().getGoodsMade(), e.getKey().getGoodsCertify(), e.getKey().getGoodsDetailContent(),
                        e.getKey().getGoodsRegisterDate(), e.getKey().getGoodsModifyDate(), e.getKey().getGoodsCategory(), e.getKey().getGoodsMainImgName(), e.getKey().getGoodsMainImgPath(), e.getKey().getGoodsMainImgUuid(), e.getValue()))
                .collect(toList())).orElseThrow(()->
                    {  throw new IllegalArgumentException("조회된 상품 없음");})
                .stream().findAny();

    }



    private Long getCount(SearchForm searchForm){
        Long count = jpaQueryFactory
                .select(goods.count())
                .from(goods)
                .where(goods.goodsCategory.stringValue().like("%"+searchForm.getCate()+"%")
                        .and(goods.goodsName.like("%" + searchForm.getKeyword()+"%")))
                .fetchOne();
        return count;
    }

    private List<GoodsDto> getGoodsList(Pageable pageable, SearchForm searchForm){
        List<GoodsDto> content = jpaQueryFactory
                .select(new QGoodsDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goods.goodsCategory.stringValue(),
                        goods.goodsRegisterDate,
                        goods.goodsModifyDate
                ))
                .from(goods)
                .where(goods.goodsCategory.stringValue().like("%"+searchForm.getCate()+"%")
                        .and(goods.goodsName.like("%" + searchForm.getKeyword()+"%")))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return content;

    }




    private List<GoodsDetailDto> getGoodsDetail(Long id){
        return jpaQueryFactory
                .select(new QGoodsDetailDto(
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
                        goods.goodsMainImg.goodsMainImgName,
                        goods.goodsMainImg.goodsMainImgPath,
                        goods.goodsMainImg.goodsMainImgUuid,
                        goodsDetailImg.goodsDetailImgName,
                        goodsDetailImg.goodsDetailImgPath,
                        goodsDetailImg.goodsDetailImgUuid
                ))
                .from(goods)
                .leftJoin(goods.goodsDetailImg, goodsDetailImg)
                .where(goods.id.eq(id))
                .fetch();
    }

}
