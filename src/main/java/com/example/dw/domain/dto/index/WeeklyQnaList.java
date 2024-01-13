package com.example.dw.domain.dto.index;

import com.example.dw.domain.dto.community.QuestionImgDto;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeeklyQnaList {


    private Long qnaBoardId;

    private Long writerUserId;
    private String writerUserAccount;
    private String writerUserNickName;
    private String qnaBoardTitle;
    private Long questionViewCount;


    private QuestionImgDto questionImgDto;


    @QueryProjection
    public WeeklyQnaList(Long qnaBoardId, Long writerUserId, String writerUserAccount, String writerUserNickName, String qnaBoardTitle, Long questionViewCount) {
        this.qnaBoardId = qnaBoardId;
        this.writerUserId = writerUserId;
        this.writerUserAccount = writerUserAccount;
        this.writerUserNickName = writerUserNickName;
        this.qnaBoardTitle = qnaBoardTitle;
        this.questionViewCount = questionViewCount;
    }


    public void setQuestionImgDto(QuestionImgDto questionImgDto) {
        this.questionImgDto = questionImgDto;
    }



}
