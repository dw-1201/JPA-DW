package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.WalkMateDetailReplyDto;

import java.util.List;

public interface WalkingMateCommentCustom {


    List<WalkMateDetailReplyDto> findReplyByWalkBoardId(Long walkBoardId);

}
