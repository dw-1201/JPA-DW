package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardCommentDto;

import java.util.List;

public interface FreeBoardCommentCustom {

    //댓글등록
    Long register(FreeBoardCommentDto freeBoardCommentDto);

    //특정 게시물의 댓글 목록
    List<FreeBoardCommentDto> getList(Long freeBoardId);

    //댓글 수정
    void modify(FreeBoardCommentDto freeBoardCommentDto);

    //댓글 삭제
    void remove(Long freeBoardCommentId);

}
