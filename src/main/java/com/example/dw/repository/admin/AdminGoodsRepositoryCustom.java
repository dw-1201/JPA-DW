package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.goods.AdminGoodsReview;
import com.example.dw.domain.form.SearchReviewForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminGoodsRepositoryCustom {



    Page<AdminGoodsReview.AdminGoodsReviewList.AdminGoodsReviewResultList> reviewList(Pageable pageable, SearchReviewForm searchReviewForm);

    AdminGoodsReview.AdminGoodsReviewDetail.AdminGoodsReviewResultDetail goodsReviewDetail(Long orderReviewId);

    AdminGoodsReview.AdminGoodsReviewApply goodsReviewReplyList(Long orderReviewId);



}
