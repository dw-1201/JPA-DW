package com.example.dw.domain.dto.index;

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

    private String questionImgRoute;
    private String questionImgUuid;
    private String questionImgName;


    @QueryProjection
    public WeeklyQnaList(Long qnaBoardId, Long writerUserId, String writerUserAccount, String writerUserNickName, String qnaBoardTitle, Long questionViewCount) {
        this.qnaBoardId = qnaBoardId;
        this.writerUserId = writerUserId;
        this.writerUserAccount = writerUserAccount;
        this.writerUserNickName = writerUserNickName;
        this.qnaBoardTitle = qnaBoardTitle;
        this.questionViewCount = questionViewCount;
    }

    @QueryProjection

    public WeeklyQnaList(Long qnaBoardId, Long writerUserId, String writerUserAccount, String writerUserNickName, String qnaBoardTitle, Long questionViewCount, String questionImgRoute, String questionImgUuid, String questionImgName) {
        this.qnaBoardId = qnaBoardId;
        this.writerUserId = writerUserId;
        this.writerUserAccount = writerUserAccount;
        this.writerUserNickName = writerUserNickName;
        this.qnaBoardTitle = qnaBoardTitle;
        this.questionViewCount = questionViewCount;
        this.questionImgRoute = questionImgRoute;
        this.questionImgUuid = questionImgUuid;
        this.questionImgName = questionImgName;
    }





    @QueryProjection
    public WeeklyQnaList(String questionImgRoute, String questionImgUuid, String questionImgName) {
        this.questionImgRoute = questionImgRoute;
        this.questionImgUuid = questionImgUuid;
        this.questionImgName = questionImgName;
    }
}
