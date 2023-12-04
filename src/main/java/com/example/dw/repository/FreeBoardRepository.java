package com.example.dw.repository;

import com.example.dw.entity.freeBoard.FreeBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FreeBoardRepository extends JpaRepository<FreeBoard, Long> {

    //검색기능 : 제목과 내용에서 특정 키워드를 포함하는 게시물 검색
//    List<FreeBoard> findAllByFreeBoardTitleContainingOrFreeBoardContentContaining(String titleKeyword, String contentKeyword);
    //메소드명의 By 이후는 SQL의 where 조건 절에 대응
    // Containing을 붙여주면 Like 검색이 가능해진다. 즉, %{keyword}%가 가능

    //최신순 (freeBoardRd가 빠른 순)
//    List<FreeBoard> findByFreeBoardTitleContainingOrFreeBoardContentContainingOrderByFreeBoardRdDesc(String titleKeyword, String contentKeyword);
    //댓글이 많은 순 (freeBoardComment가 많은 순)
//    List<FreeBoard> findByFreeBoardTitleContainingOrFreeBoardContentContainingOrderByFreeBoardCommentSizeDesc(String titleKeyword, String contentKeyword);
    //인기순 (freeBoardViewCount가 높은 순)
//    List<FreeBoard> findByFreeBoardTitleContainingOrFreeBoardContentContainingOrderByFreeBoardViewCountDesc(String titleKeyword, String contentKeyword);
}
