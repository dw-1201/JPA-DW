package com.example.dw.repository.admin;

import com.example.dw.domain.entity.order.GoodsReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminGoodsReviewRepository extends JpaRepository<GoodsReviewReply, Long> {

    @Modifying
    @Query("update GoodsReviewReply gr set gr.goodsReviewReplyContent=:modContent, gr.goodsReviewReplyMD=current_timestamp where gr.id=:id")
    void updateReviewReply(@Param("modContent") String modContent, @Param("id")Long id);
}
