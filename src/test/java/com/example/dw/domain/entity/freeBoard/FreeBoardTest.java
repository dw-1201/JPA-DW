//package com.example.dw.domain.entity.freeBoard;
//
//import com.example.dw.domain.entity.user.Users;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//
//@SpringBootTest
//@Transactional
//@Commit
//class FreeBoardTest {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Test
//    void EntityTest(){
//        Users users = new Users();
//        users.setUserAccount("사용자 계정");
//        users.setUserName("사용자 이름");
//        users.setUserPassword("사용자 비밀번호");
//        users.setUserEmail("사용자 이메일");
//        users.setUserPhone("사용자 전화번호");
//        users.setZipCode("우편번호");
//        users.setAddress("주소");
//        users.setDetail("상세주소");
//
//        em.persist(users);
//
//        FreeBoard freeBoard = new FreeBoard();
//        freeBoard.setUsers(users);
//        freeBoard.setFreeBoardTitle("제목");
//        freeBoard.setFreeBoardContent("내용");
//        freeBoard.setFreeBoardRd(LocalDateTime.now());
//        freeBoard.setFreeBoardMd(LocalDateTime.now());
//        freeBoard.setFreeBoardViewCount(1L);
//
//        em.persist(freeBoard);
//
//        FreeBoardComment freeBoardComment = new FreeBoardComment();
//        freeBoardComment.setFreeBoardCommentContent("댓글내용");
//        freeBoardComment.setFreeBoardCommentRd(LocalDateTime.now());
//        freeBoardComment.setFreeBoardCommentMd(LocalDateTime.now());
//        freeBoardComment.setFreeBoard(freeBoard);
//
//        em.persist(freeBoardComment);
//
//        FreeBoardImg freeBoardImg = new FreeBoardImg();
//        freeBoardImg.setFreeBoardImgName("이미지이름");
//        freeBoardImg.setFreeBoardImgRoute("이미지경로");
//        freeBoardImg.setFreeBoardImgUuid("이미지uuid");
//        freeBoardImg.setFreeBoard(freeBoard);
//
//        em.persist(freeBoardImg);
//
//        FreeBoardLike freeBoardLike = new FreeBoardLike();
//        freeBoardLike.setFreeBoardLikeLike(1L);
//        freeBoardLike.setFreeBoardLikeState(2L);
//        freeBoardLike.setFreeBoard(freeBoard);
//
//        em.persist(freeBoardLike);
//    }
//}
