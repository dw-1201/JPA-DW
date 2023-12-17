package com.example.dw.repository.freeBoard;

import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FreeBoardCommentRepository extends JpaRepository<FreeBoardComment, Long> {

    /**
     * 게시물 번호로 댓글 삭제
     * update, delete 를 위한 어노테이션
     * @param freeBoardId
     */
    @Modifying
    @Query("delete from FreeBoardComment f where f.freeBoard.id = :freeBoardId")
    void deleteByFreeBoardId(@Param("freeBoardId") Long freeBoardId);

    //특정 게시물 번호로 댓글 가져오기
}
