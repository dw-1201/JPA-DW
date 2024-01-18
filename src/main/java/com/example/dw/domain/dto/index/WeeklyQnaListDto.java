package com.example.dw.domain.dto.index;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeeklyQnaListDto {

    private Long qnaBoardId;

    private Long writerUserId;
    private String writerUserAccount;
    private String writerUserNickName;
    private String qnaBoardTitle;
    private Long questionViewCount;

    private WeeklyQnaListImg weeklyQnaListImg;


    public WeeklyQnaListDto(Long qnaBoardId, Long writerUserId, String writerUserAccount, String writerUserNickName, String qnaBoardTitle, Long questionViewCount, WeeklyQnaListImg weeklyQnaListImg) {
        this.qnaBoardId = qnaBoardId;
        this.writerUserId = writerUserId;
        this.writerUserAccount = writerUserAccount;
        this.writerUserNickName = writerUserNickName;
        this.qnaBoardTitle = qnaBoardTitle;
        this.questionViewCount = questionViewCount;
        this.weeklyQnaListImg = weeklyQnaListImg;
    }


    public WeeklyQnaListDto setImgs(WeeklyQnaListImg img){
        this.weeklyQnaListImg = img;
        return this;

    }
}
