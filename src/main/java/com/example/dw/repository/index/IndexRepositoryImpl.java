package com.example.dw.repository.index;

import com.example.dw.domain.dto.community.QQuestionImgDto;
import com.example.dw.domain.dto.community.QuestionImgDto;
import com.example.dw.domain.dto.index.QWeeklyQnaList;
import com.example.dw.domain.dto.index.WeeklyFreeBoardList;
import com.example.dw.domain.dto.index.WeeklyQnaList;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

import static com.example.dw.domain.entity.question.QQuestion.question;
import static com.example.dw.domain.entity.question.QQuestionImg.questionImg;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class IndexRepositoryImpl implements IndexRepositoryCustom{


    private final JPAQueryFactory jpaQueryFactory;


    //해당 날짜가 껴있는 주간날짜 구하기
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime thisWeekStart = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).toLocalDate().atStartOfDay();
    LocalDateTime thisWeekEnd = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY)).toLocalDate().atTime(23, 59, 59);

    //주간 Qna인기글 Top3
    @Override
    public List<WeeklyQnaList> weeklyQnaList() {

        System.out.println("이번주 start date: " + thisWeekStart);
        System.out.println("이번주 end date: " + thisWeekEnd);

        List<WeeklyQnaList> weeklyQnaLists = jpaQueryFactory.select(new QWeeklyQnaList(
                question.id,
                question.users.id,
                question.users.userAccount,
                question.users.userNickName,
                question.questionTitle,
                question.questionViewCount
        ))
                .from(question)
                .leftJoin(question.users, users)
                .where(question.questionRd.between(thisWeekStart, thisWeekEnd))
                .orderBy(question.questionViewCount.desc())
                .limit(3)
                .fetch();

        for (WeeklyQnaList weeklyQnaList : weeklyQnaLists) {
            Long boardId = weeklyQnaList.getQnaBoardId();

            QuestionImgDto questionImgDto = jpaQueryFactory.select(new QQuestionImgDto(
                    questionImg.id,
                    questionImg.questionImgRoute,
                    questionImg.questionImgName,
                    questionImg.questionImgUuid
            ))
                    .from(questionImg)
                    .where(questionImg.question.id.eq(boardId))
                    .fetchFirst();

            weeklyQnaList.setQuestionImgDto(questionImgDto);
        }

        return weeklyQnaLists;
    }

    @Override
    public List<WeeklyFreeBoardList> weeklyFreeBoardList() {
        return null;
    }

    //주간 자유게시판 인기글 Top3
}
