package com.example.dw.repository.index;

import com.example.dw.domain.dto.index.QWeeklyFreeBoardList;
import com.example.dw.domain.dto.index.WeeklyFreeBoardList;
import com.example.dw.domain.dto.index.WeeklyQnaList;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.dw.domain.entity.freeBoard.QFreeBoard.freeBoard;
import static com.example.dw.domain.entity.question.QQuestion.question;
import static com.example.dw.domain.entity.question.QQuestionImg.questionImg;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class IndexRepositoryImpl implements IndexRepositoryCustom{


    private final JPAQueryFactory jpaQueryFactory;

    private static final int MAX_RESULTS = 3;

    //해당 날짜가 껴있는 주간날짜 구하기
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime thisWeekStart = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toLocalDate().atStartOfDay();
    LocalDateTime thisWeekEnd = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toLocalDate().atTime(23, 59, 59);

    //주간 Qna인기글 Top3
    @Override
    public List<WeeklyQnaList> weeklyQnaList() {
        List<Tuple> tuples = jpaQueryFactory
                .select(
                        question.id,
                        question.users.id,
                        question.users.userAccount,
                        question.users.userNickName,
                        question.questionTitle,
                        question.questionViewCount,
                        questionImg.questionImgRoute,
                        questionImg.questionImgUuid,
                        questionImg.questionImgName
                )
                .from(question)
                .leftJoin(question.users, users)
                .leftJoin(question.questionImg, questionImg)
                .where(question.questionRd.between(thisWeekStart, thisWeekEnd))
                .orderBy(question.questionViewCount.desc(), questionImg.id.asc())
                .fetch();

        List<WeeklyQnaList> weeklyQnaLists = new ArrayList<>();


        for (Tuple tuple : tuples) {
            Long questionId = tuple.get(question.id);

            boolean isQuestionIdExist = isQuestionIdExist(weeklyQnaLists, questionId);

            //중복 입력 방지
            if (!isQuestionIdExist) {
                WeeklyQnaList weeklyQnaList = new WeeklyQnaList(
                        tuple.get(question.id),
                        tuple.get(question.users.id),
                        tuple.get(question.users.userAccount),
                        tuple.get(question.users.userNickName),
                        tuple.get(question.questionTitle),
                        tuple.get(question.questionViewCount),
                        tuple.get(questionImg.questionImgRoute),
                        tuple.get(questionImg.questionImgUuid),
                        tuple.get(questionImg.questionImgName)
                );

                weeklyQnaLists.add(weeklyQnaList);
            }
        }

        // 최대 3개까지만 반환
        return weeklyQnaLists.stream()
                .limit(MAX_RESULTS)
                .collect(Collectors.toList());
    }

    //중복 확인 메소드
    private boolean isQuestionIdExist(List<WeeklyQnaList> weeklyQnaLists, Long questionId) {
        return weeklyQnaLists.stream()
                .anyMatch(item -> item.getQnaBoardId().equals(questionId));
    }



    //주간 자유게시판 인기글 Top3
    @Override
    public List<WeeklyFreeBoardList> weeklyFreeBoardList() {


        List<WeeklyFreeBoardList> weeklyFreeLists = jpaQueryFactory.select(
                new QWeeklyFreeBoardList(
                        freeBoard.id,
                        freeBoard.freeBoardTitle,
                        freeBoard.freeBoardViewCount
                )
        )
                .from(freeBoard)
                .where(freeBoard.freeBoardRd.between(thisWeekStart, thisWeekEnd))
                .orderBy(freeBoard.freeBoardViewCount.desc())
                .limit(5)
                .fetch();
        return weeklyFreeLists;
    }


}
