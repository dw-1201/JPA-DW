package com.example.dw.repository.community;


import com.example.dw.domain.dto.community.QuestionDetailReplyDto;

import java.util.List;

public interface QuestionCommentRepositoryCustom {

    List<QuestionDetailReplyDto> findReplyByQuestionBoardId(Long questionId);


}
