package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.form.SearchReviewForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.dw.domain.entity.goods.QGoods.goods;
import static com.example.dw.domain.entity.order.QGoodsReviewReply.goodsReviewReply;
import static com.example.dw.domain.entity.goods.QGoodsMainImg.goodsMainImg;
import static com.example.dw.domain.entity.order.QOrderItem.orderItem;
import static com.example.dw.domain.entity.order.QOrderReview.orderReview;
import static com.example.dw.domain.entity.order.QOrderReviewImg.orderReviewImg;
import static com.example.dw.domain.entity.order.QOrders.orders;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class AdminGoodsRepositoryImpl implements AdminGoodsRepositoryCustom{



    private final JPQLQueryFactory jpqlQueryFactory;

    @Override
    public Page<AdminGoodsReviewResultDto> reviewList(Pageable pageable, SearchReviewForm searchReviewForm) {




        List<AdminGoodsReviewListDto> query = jpqlQueryFactory.select(
                new QAdminGoodsReviewListDto(
                        orderReview.id,
                        goods.goodsCategory.stringValue(),
                        goods.goodsName,
                        orderReview.content,
                        orderReview.rating,
                        orderReview.reviewRd,
                        orderReview.adminReplyState
                )
        )
                .from(orderReview)
                .leftJoin(orderReview.orderItem, orderItem)
                .leftJoin(orderItem.goods, goods)
                .where(
                        cateGoryNameEq(searchReviewForm),
                        goodsNameEq(searchReviewForm),
                        createRecruitmentStatusCondition(searchReviewForm)

                )
                .orderBy(orderReview.id.desc())
                .fetch();


        Long getTotal = jpqlQueryFactory.select(
                orderReview.count()
        )
                .from(orderReview)
                .where(
                        cateGoryNameEq(searchReviewForm),
                        goodsNameEq(searchReviewForm),
                        createRecruitmentStatusCondition(searchReviewForm)

                )
                .fetchOne();

        List<AdminGoodsReviewResultDto> result = query.stream().map(orderReviews ->  new AdminGoodsReviewResultDto(
                orderReviews.getOrderReviewId(),
                new AdminGoodsReviewListDtoWithoutId(
                        orderReviews.getGoodsCategory(), orderReviews.getGoodsName(),
                        orderReviews.getOrderReviewContent(), orderReviews.getRating(),
                        orderReviews.getOrderReviewRd(),orderReviews.getAdminReplyState())
                )
        ).collect(Collectors.toList());


        return new PageImpl<>(result, pageable, getTotal);
    }

    //상품 리뷰 상세
    @Override
    public AdminGoodsReviewDetailResultDto goodsReviewDetail(Long orderReviewId) {

        AdminGoodsReviewInfo goodsInfo = jpqlQueryFactory.select(
                new QAdminGoodsReviewInfo(
                        goods.id,
                        goods.goodsCategory.stringValue(),
                        goods.goodsName,
                        goods.goodsDetailContent,
                        orderReview.rating.avg(),
                        goodsMainImg.goodsMainImgPath,
                        goodsMainImg.goodsMainImgUuid,
                        goodsMainImg.goodsMainImgName

                )
        )
                .from(orderReview)
                .leftJoin(orderReview.orderItem, orderItem)
                .leftJoin(orderItem.goods, goods)
                .leftJoin(goods.goodsMainImg, goodsMainImg)
                .where(orderReview.id.eq(orderReviewId))
                .groupBy(goods.id, goods.goodsCategory, goods.goodsName, goods.goodsDetailContent,
                        goodsMainImg.goodsMainImgPath, goodsMainImg.goodsMainImgUuid, goodsMainImg.goodsMainImgName)
                .fetchOne();

        List<AdminGoodsReviewContentDto> reviewInfo = jpqlQueryFactory.select(
                new QAdminGoodsReviewContentDto(
                        orderReview.content,
                        users.userAccount,
                        orderReview.rating,
                        orderReview.reviewRd,
                        orderReviewImg.id,
                        orderReviewImg.reviewimgPath,
                        orderReviewImg.reviewimgUuid,
                        orderReviewImg.reviewimgFileName
                )

        ).from(orderReviewImg)

                .leftJoin(orderReviewImg.orderReview, orderReview)
                .leftJoin(orderReview.orderItem, orderItem)
                .leftJoin(orderItem.orders, orders)
                .leftJoin(orders.users, users)
                .where(orderReview.id.eq(orderReviewId))
                .fetch();


        AdminGoodsReviewInfoDto goodsInfoResult = new AdminGoodsReviewInfoDto(

                goodsInfo.getGoodsId(), goodsInfo.getGoodsCategory(), goodsInfo.getGoodsName(),
                goodsInfo.getGoodsContent(), goodsInfo.getRatingAvg(),

                new AdminGoodsReviewMainImgDto(goodsInfo.getGoodsMainImgPath(),
                        goodsInfo.getGoodsMainImgUuid(), goodsInfo.getGoodsMainImgName())
        );


        AdminGoodsReviewContentResultDto reviewInfoResult = reviewInfo.stream().map(
                reviews -> new AdminGoodsReviewContentResultDto(
                        reviews.getOrderReviewContent(),
                        reviews.getUserAccount(),
                        reviews.getRating(),
                        reviews.getOrderReviewRd(),

                        reviewInfo.stream().map(o->new AdminGoodsReviewImgList(
                                o.getOrderReviewImgId(), o.getOderReviewImgPath(),
                                o.getOrderReviewImgUuid(), o.getOrderReviewImgName()
                        )).collect(Collectors.toList()))).

                findFirst().get();



        return new AdminGoodsReviewDetailResultDto(orderReviewId, goodsInfoResult, reviewInfoResult);
    }

    //상품 리뷰 관리자 답변 가져오기
    @Override
    public AdminGoodsReviewReplyDto goodsReviewReplyList(Long orderReviewId) {
        return jpqlQueryFactory.select(
                new QAdminGoodsReviewReplyDto(
                        goodsReviewReply.id,
                        goodsReviewReply.goodsReviewReplyContent,
                        goodsReviewReply.goodsReviewReplyRD,
                        goodsReviewReply.goodsReviewReplyMD
                )
        )
                .from(goodsReviewReply)
                .where(goodsReviewReply.orderReview.id.eq(orderReviewId))
                .fetchOne();
    }


    private BooleanExpression cateGoryNameEq(SearchReviewForm searchReviewForm){
        return StringUtils.hasText(searchReviewForm.getCate()) ? orderItem.goods.goodsCategory.stringValue().eq(searchReviewForm.getCate()) : null;
    }

    private BooleanExpression goodsNameEq(SearchReviewForm searchReviewForm){
        return StringUtils.hasText(searchReviewForm.getKeyword()) ? orderItem.goods.goodsName.containsIgnoreCase(searchReviewForm.getKeyword()) : null;
    }


    private BooleanExpression createRecruitmentStatusCondition(SearchReviewForm searchReviewForm) {
        try{
            if (searchReviewForm.getAdminReplyState().equals("0")) { // 모집중
                return orderReview.adminReplyState.eq(0);
            } else if (searchReviewForm.getAdminReplyState().equals("1")) { // 모집완료
                return orderReview.adminReplyState.eq(1);
            } else { // 전체보기 ('' 인 경우)
                return null; // 특정 조건 없이 모든 결과 반환
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }



}


