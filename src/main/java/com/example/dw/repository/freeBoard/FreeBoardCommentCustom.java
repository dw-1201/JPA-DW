package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardCommentDto;

import java.util.List;

public interface FreeBoardCommentCustom {


    //댓글 목록 불러오기
    List<FreeBoardCommentDto> findFreeBoardCommentsByFreeBoardId(Long freeBoardId);


}
