package com.example.dw.entity.freeBoard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Commit
class FreeBoardTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    void EntityTest(){
        FreeBoard freeBoard = new FreeBoard();
        FreeBoardComment freeBoardComment =new FreeBoardComment();
        FreeBoardImg freeBoardImg = new FreeBoardImg();
        FreeBoardLike freeBoardLike = new FreeBoardLike();

        freeBoard.setFreeBoardTitle("제목");
        freeBoard.setFreeBoardContent("내용");
        freeBoard.setFreeBoardRd(LocalDateTime.now());
        freeBoard.setFreeBoardMd(LocalDateTime.now());
        freeBoard.setFreeBoardViewCount(1L);

        freeBoardComment.setFreeBoardCommentContent("댓글내용");
        freeBoardComment.setFreeBoardCommentRd(LocalDateTime.now());
        freeBoardComment.setFreeBoardCommentMd(LocalDateTime.now());
        freeBoardComment.setFreeBoard(freeBoard);

        em.persist(freeBoardComment);

        freeBoardImg.setFreeBoardImgName("이미지이름");
        freeBoardImg.setFreeBoardImgRoute("이미지경로");
        freeBoardImg.setFreeBoardImgUuid("이미지uuid");
        freeBoardImg.setFreeBoard(freeBoard);

        em.persist(freeBoardImg);

        freeBoardLike.setFreeBoardLikeLike(1L);
        freeBoardLike.setFreeBoardLikeState(2L);
        freeBoardLike.setFreeBoard(freeBoard);

        em.persist(freeBoardLike);

        em.persist(freeBoard);
    }
}