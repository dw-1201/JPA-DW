package com.example.dw.repository.admin;

import com.example.dw.domain.entity.order.GoodsReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminGoodsReviewRepository extends JpaRepository<GoodsReviewReply, Long> {

    //상품 리뷰 관리자 답변 수정
    @Modifying
    @Query("update GoodsReviewReply gr set gr.goodsReviewReplyContent=:modContent, gr.goodsReviewReplyMD=current_timestamp where gr.id=:id")
    void updateReviewReply(@Param("modContent") String modContent, @Param("id")Long id);

    //상품 리뷰 답변 시 상태 변경
    @Modifying
    @Query("update OrderReview or set or.adminReplyState=1 where or.id=:id")
    void updateOrderReviewState(@Param("id")Long id);

    //상품 리뷰 답변 삭제 시 상태 변경
    @Modifying
    @Query("update OrderReview or set or.adminReplyState=0 where or.id=:id")
    void deleteOrderReviewState(@Param("id")Long id);

}
