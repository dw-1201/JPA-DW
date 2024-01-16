package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminGoodsReviewDetailResultDto;
import com.example.dw.domain.dto.admin.AdminGoodsReviewReplyDto;
import com.example.dw.domain.dto.admin.AdminGoodsReviewResultDto;
import com.example.dw.domain.form.SearchReviewForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminGoodsRepositoryCustom {



    Page<AdminGoodsReviewResultDto> reviewList(Pageable pageable, SearchReviewForm searchReviewForm);

    AdminGoodsReviewDetailResultDto goodsReviewDetail(Long orderReviewId);

    AdminGoodsReviewReplyDto goodsReviewReplyList(Long orderReviewId);


}
