package com.example.dw.repository.community;

import com.example.dw.domain.entity.walkingMate.WalkingMateComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WalkingMateCommentRepository extends JpaRepository<WalkingMateComment, Long> {


    @Modifying
    @Query("update WalkingMateComment wc set wc.walkingMateCommentContent=:modifiedComment, wc.walkingMateCommentRd=current_date where wc.id=:id")
    void updateComment(@Param("modifiedComment") String modifiedComment, @Param("id")Long id);
}
