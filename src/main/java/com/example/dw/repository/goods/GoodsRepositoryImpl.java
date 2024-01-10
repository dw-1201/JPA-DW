package com.example.dw.repository.goods;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
import com.example.dw.domain.dto.goods.QIndexGoodsByCateDto;
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
import java.util.Optional;

import static com.example.dw.domain.entity.goods.QGoods.goods;
import static com.example.dw.domain.entity.goods.QGoodsDetailImg.goodsDetailImg;
import static com.example.dw.domain.entity.goods.QGoodsMainImg.goodsMainImg;
import static com.example.dw.domain.entity.goods.QGoodsQue.goodsQue;
import static com.example.dw.domain.entity.goods.QGoodsQueReply.goodsQueReply;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    //메인페이지 카테고리별 상품리스트
    @Override
    public List<IndexGoodsByCateDto> indexGoodsListByCategory(String cate) {
        return jpaQueryFactory.select(new QIndexGoodsByCateDto(
                goods.id,
                goods.goodsName,
                goods.goodsPrice,
                goods.goodsCategory.stringValue(),
                goodsMainImg.id,
                goodsMainImg.goodsMainImgPath,
                goodsMainImg.goodsMainImgUuid,
                goodsMainImg.goodsMainImgName
        ))

                .from(goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .limit(6)
                .where(goods.goodsCategory.stringValue().eq(cate))
                .orderBy(goods.id.desc())
                .fetch();
    }

    //관리자 페이지 상품 리스트
    @Override
    public Page<AdminGoodsDto> findGoodsAll(Pageable pageable, SearchForm searchForm) {
        List<AdminGoodsDto> contents = jpaQueryFactory
                .select(new QAdminGoodsDto(
                        goods.id,
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.saleCount,
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


        Long count = jpaQueryFactory
                .select(goods.count())
                .from(goods)
                .where(
                        cateGoryNameEq(searchForm),
                        goodsNameEq(searchForm)
                )
                .fetchOne();


        System.out.println("[상품 개수] :"+ count +"개");

        return new PageImpl<>(contents, pageable,count);
    }

    //관리자 페이지 상품 상세 페이지
    @Override
    public List<AdminGoodsDetailDto> findGoodsById(Long id) {

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
                        goodsDetailImg.goodsDetailImgUuid,
                        goods.saleCount
                ))
                .from(goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .leftJoin(goods.goodsDetailImg, goodsDetailImg)
                .where(goods.id.eq(id))
                .fetch();
//        return
//                list.stream().collect(groupingBy(o->new AdminGoodsDetailResultDto(
//                        o.getId(),o.getGoodsName(),o.getGoodsQuantity(), o.getGoodsPrice(), o.getGoodsMade(), o.getGoodsCertify(), o.getGoodsDetailContent(),
//                        o.getGoodsRegisterDate(), o.getGoodsModifyDate(), o.getGoodsCategory(), o.getGoodsMainImgName(), o.getGoodsMainImgPath(), o.getGoodsMainImgUuid()), mapping(o->new AdminGoodsDetailImgDto(
//                                o.getId(), o.getGoodsDetailImgName(), o.getGoodsDetailImgPath(), o.getGoodsDetailImgUuid(), o.getGoodsDetailImgId()),toList())
//                        )
//                ).entrySet().stream().map(e->new AdminGoodsDetailResultDto(
//                        e.getKey().getId(), e.getKey().getGoodsName(), e.getKey().getGoodsQuantity(), e.getKey().getGoodsPrice(), e.getKey().getGoodsMade(), e.getKey().getGoodsCertify(),
//                        e.getKey().getGoodsDetailContent(), e.getKey().getGoodsRegisterDate(), e.getKey().getGoodsModifyDate(), e.getKey().getGoodsCategory(),
//                        e.getKey().getGoodsMainImgName(),e.getKey().getGoodsMainImgPath(), e.getKey().getGoodsMainImgUuid(), e.getValue())).collect(toList());


    }
    //상품 상세 - 상품 관련 문의사항
    @Override
    public Page<AdminGoodsQnaListDto> getQnaList(Long goodsId, Pageable pageable, String state){
        List<AdminGoodsQnaListDto> lists = jpaQueryFactory.select(new QAdminGoodsQnaListDto(
                goodsQue.id,
                goods.goodsCategory.stringValue(),
                goods.id,
                goods.goodsName,
                goodsQue.queContent,
                goodsQue.queRegisterDate,
                goodsQue.state
        ))
                .from(goodsQue)
                .leftJoin(goodsQue.goods, goods)
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .where(goodsQue.goods.id.eq(goodsId).and(
                        qnaStateEq(state)
                ))
                .orderBy(goodsQue.id.desc())
                .fetch();

        Long qnaListCount = jpaQueryFactory.select(
                goodsQue.count()
        )
                .from(goodsQue)
                .where(goodsQue.goods.id.eq(goodsId).and(
                        qnaStateEq(state)))

                .fetchOne();

        return new PageImpl<>(lists, pageable, qnaListCount);

    }


    //관리자 Qna리스트
    @Override
    public Page<AdminGoodsQnaListDto> getQnaList(Pageable pageable, String qnaState, String cate, String keyword) {
        List<AdminGoodsQnaListDto> lists = jpaQueryFactory.select(new QAdminGoodsQnaListDto(
                goodsQue.id,
                goods.goodsCategory.stringValue(),
                goods.id,
                goods.goodsName,
                goodsQue.queContent,
                goodsQue.queRegisterDate,
                goodsQue.state
        ))
                .from(goodsQue)
                .leftJoin(goodsQue.goods, goods)
                .where(
                        qnaStateEq(qnaState),
                        cateGoryNameEq(cate),
                        goodsNameEq(keyword)
                )
                .orderBy(goodsQue.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long qnaListCount = jpaQueryFactory.select(
                goodsQue.count()
        )
                .from(goodsQue)
                .where(
                        qnaStateEq(qnaState),
                        cateGoryNameEq(cate),
                        goodsNameEq(keyword)
                )
                .fetchOne();


        return new PageImpl<>(lists, pageable, qnaListCount);
    }

    //관리자 상품 문의 상세 - 문의 정보 / 상품 기본 정보 / 상품 메인 사진
    @Override
    public Optional<AdminGoodsQueDetailDto> getQnaDetail(Long qnaId) {
        return Optional.ofNullable(jpaQueryFactory.select(new QAdminGoodsQueDetailDto(
                goodsQue.id,
                goodsQue.queContent,
                goodsQue.queRegisterDate,
                goodsQue.queModifyDate,
                goodsQue.state,
                users.id,
                users.userAccount,
                users.userNickName,
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
                goodsMainImg.goodsMainImgName,
                goodsMainImg.goodsMainImgPath,
                goodsMainImg.goodsMainImgUuid

        ))
                .from(goodsQue)
                .leftJoin(goodsQue.users, users)
                .leftJoin(goodsQue.goods, goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .where(goodsQue.id.eq(qnaId))
                .fetchOne());
    }

    //관리자 상품 문의 답변 내역 가져오기
    @Override
    public AdminGoodsQueReplyDto getReplyList(Long qnaId) {
        return jpaQueryFactory.select(new QAdminGoodsQueReplyDto(
                goodsQueReply.id,
                goodsQueReply.queReplyContent,
                goodsQueReply.queReplyRegisterDate,
                goodsQueReply.queReplyModifyDate
        ))
                .from(goodsQueReply)
                .where(goodsQueReply.goodsQue.id.eq(qnaId))
                .fetchOne();
    }




    //상품 리스트 동적 검색
    private BooleanExpression cateGoryNameEq(SearchForm searchForm){
        return StringUtils.hasText(searchForm.getCate()) ? goods.goodsCategory.stringValue().eq(searchForm.getCate()) : null;
    }

    private BooleanExpression goodsNameEq(SearchForm searchForm){
        return StringUtils.hasText(searchForm.getKeyword()) ? goods.goodsName.containsIgnoreCase(searchForm.getKeyword()) : null;
    }


    //상품 문의 동적 검색
    private BooleanExpression cateGoryNameEq(String cate){
        return StringUtils.hasText(cate) ? goods.goodsCategory.stringValue().eq(cate) : null;
    }

    private BooleanExpression goodsNameEq(String keyword){
        return StringUtils.hasText(keyword) ? goods.goodsName.containsIgnoreCase(keyword) : null;
    }

    //문의상태
    private BooleanExpression qnaStateEq(String qnaState){

        return StringUtils.hasText(qnaState) ? goodsQue.state.eq(Integer.valueOf(qnaState)) : null;
    }


}
