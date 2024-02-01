package com.example.dw.repository.goods;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.dto.admin.goods.*;
import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
import com.example.dw.domain.entity.goods.GoodsCategory;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
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
import static com.example.dw.domain.entity.order.QOrderItem.orderItem;
import static com.example.dw.domain.entity.order.QOrderReview.orderReview;
import static com.example.dw.domain.entity.user.QUsers.users;
import static java.util.stream.Collectors.toList;

@Repository
@RequiredArgsConstructor
public class GoodsRepositoryImpl implements GoodsRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager em;

    //메인페이지 카테고리별 상품리스트
    @Override
    public List<IndexGoodsByCateDto> indexGoodsListByCategory(GoodsCategory goodsCategory) {

        List<IndexGoodsByCateDto> list = em.createQuery(
                "select NEW com.example.dw.domain.dto.goods.IndexGoodsByCateDto(" +
                        "g.id, g.goodsName, g.goodsPrice, avg(or.rating), g.goodsCategory, gm.id, gm.goodsMainImgPath, gm.goodsMainImgUuid, gm.goodsMainImgName) FROM Goods g " +
                        "left join GoodsMainImg gm on gm.goods.id=g.id " +
                        "left join OrderItem oi on oi.goods.id=g.id " +
                        "left join OrderReview or on or.orderItem.id=oi.id " +
                        "where g.goodsCategory =:goodsCategory " +
                        "group by g.id, g.goodsName, g.goodsPrice, g.goodsCategory, gm.id, gm.goodsMainImgPath, gm.goodsMainImgUuid, gm.goodsMainImgName " +
                        "order by g.id desc", IndexGoodsByCateDto.class)
                .setParameter("goodsCategory", goodsCategory)
                .setMaxResults(6)  // 최대 6개 결과를 가져오도록 설정
                .getResultList();

        return list;
    }

    //관리자 페이지 상품 리스트
    @Override
    public Page<AdminGoods.AdminGoodsList> findGoodsAll(Pageable pageable, SearchForm searchForm) {
        List<AdminGoods.AdminGoodsList> contents = jpaQueryFactory
                .select(new QAdminGoods_AdminGoodsList(
                        goods.id,
                        goods.goodsCategory.stringValue(),
                        goods.goodsName,
                        goods.goodsQuantity,
                        goods.saleCount,
                        goods.goodsPrice,
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
    public AdminGoods.AdminGoodsDetail findGoodsById(Long id) {
    
        Double avg =
                jpaQueryFactory.select(

                        orderReview.rating.avg().coalesce(0.0))
                        .from(orderReview)
                        .leftJoin(orderReview.orderItem, orderItem)
                        .leftJoin(orderItem.goods, goods)
                        .where(goods.id.eq(id))
                        .fetchOne();

        List<AdminGoods> detail= jpaQueryFactory
                .select(new QAdminGoods(
                        goods.id,
                        goods.goodsName,
                        goods.goodsCategory.stringValue(),
                        goods.goodsQuantity,
                        goods.goodsPrice,
                        goods.saleCount,
                        goods.goodsDetailContent,
                        goods.goodsMade,
                        goods.goodsCertify,
                        goods.goodsRegisterDate,
                        goods.goodsModifyDate,
                        goodsMainImg.id,
                        goodsMainImg.goodsMainImgPath,
                        goodsMainImg.goodsMainImgUuid,

                        goodsMainImg.goodsMainImgName,
                        goodsDetailImg.id,
                        goodsDetailImg.goodsDetailImgPath,
                        goodsDetailImg.goodsDetailImgUuid,
                        goodsDetailImg.goodsDetailImgName
                        ))
                        .from(goods)
                        .leftJoin(goods.goodsMainImg, goodsMainImg)
                        .leftJoin(goods.goodsDetailImg, goodsDetailImg)
                        .where(goods.id.eq(id))
                        .fetch();


        AdminGoods.AdminGoodsDetail sss = detail.stream().map(
                o -> new AdminGoods.AdminGoodsDetail(
                        o.getGoodsId(), o.getGoodsName(), o.getGoodsCategory(), o.getGoodsQuantity(),
                        o.getGoodsPrice(), o.getGoodsSaleCount(), o.getGoodsDetailContent(), o.getGoodsMate(),
                        o.getGoodsCertify(), o.getGoodsRd(), o.getGoodsMd(), avg, o.getGoodsMainImgPath(), o.getGoodsMainImgUuid(), o.getGoodsMainImgName())
        ).findFirst().get();

        List<AdminGoods.AdminGoodsDetailImg> imgs = detail.stream().map(
                img -> new AdminGoods.AdminGoodsDetailImg(img.getGoodsDetailImgId(), img.getGoodsDetailImgPath(), img.getGoodsDetailImgUuid(), img.getGoodsDetailImgName())
        ).collect(toList());

        sss.setGoodsDetailImg(imgs);


        return sss;
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
    
    //상품 상세 - 상품 관련 리뷰
    @Override
    public Page<AdminGoodsReview.AdminGoodsRelatedReview> getReviewList(Long goodsId, Pageable pageable, String state) {
        List<AdminGoodsReview.AdminGoodsRelatedReview> lists = jpaQueryFactory.select(new QAdminGoodsReview_AdminGoodsRelatedReview(
                orderReview.id,
                orderReview.content,
                orderReview.rating,
                orderReview.reviewRd,
                orderReview.adminReplyState
        ))
                .from(orderReview)
                .leftJoin(orderReview.orderItem, orderItem)
                .leftJoin(orderItem.goods, goods)
                .where(goods.id.eq(goodsId).and(
                        reviewStateEq(state)
                ))
                .fetch();


        Long getTotal = jpaQueryFactory.select(
                orderReview.count()
        )
                .from(orderReview)
                .leftJoin(orderReview.orderItem, orderItem)
                .leftJoin(orderItem.goods, goods)
                .where(goods.id.eq(goodsId).and(
                        reviewStateEq(state)
                ))
                .fetchOne();

        return new PageImpl<>(lists, pageable, getTotal);
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
                goods.goodsQuantity.subtract(goods.saleCount),
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


    //리뷰 답변 상태
    private BooleanExpression reviewStateEq(String reviewState){

        return StringUtils.hasText(reviewState) ? orderReview.adminReplyState.eq(Integer.valueOf(reviewState)) : null;
    }


}
