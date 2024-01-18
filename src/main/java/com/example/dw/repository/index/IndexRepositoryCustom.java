package com.example.dw.repository.index;

import com.example.dw.domain.dto.index.WeeklyFreeBoardList;
import com.example.dw.domain.dto.index.WeeklyQnaList;

import java.util.List;

public interface IndexRepositoryCustom {


    //메인페이지 주간 인기글

    //QnA인기글
    List<WeeklyQnaList> weeklyQnaList();

    //자유게시판 인기글
    List<WeeklyFreeBoardList> weeklyFreeBoardList();


//
//    @Query("select distinct q.id, q.users.id, q.users.userAccount, q.users.userNickName, q.questionTitle, q.questionViewCount, (select qi.questionImgRoute, qi.questionImgUuid, qi.qustionImgName from QuestionImg qi where qi.question = q) as imgs from Question q " +
//            "left join  ")
//    List<WeeklyQnaList> qnaTop3();
//

}
