package com.example.dw.repository.freeBoard;

import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FreeBoardCommentRepository extends JpaRepository<FreeBoardComment, Long> {

    // 게시물의 댓글 갯수 조회
    @Query("SELECT COUNT(fbc) FROM FreeBoardComment fbc WHERE fbc.freeBoard.id = :freeBoardId")
    Long countCommentsByFreeBoardId(@Param("freeBoardId") Long freeBoardId);

}
