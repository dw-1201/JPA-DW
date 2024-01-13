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




}
