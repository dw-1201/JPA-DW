package com.example.dw.repository.community;


import com.example.dw.domain.dto.community.QQuestionCommentDto;
import com.example.dw.domain.dto.community.QQuestionDetailReplyDto;
import com.example.dw.domain.dto.community.QuestionDetailReplyDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.example.dw.domain.entity.question.QQuestionComment.questionComment;
import static com.example.dw.domain.entity.user.QUsers.users;
import static com.example.dw.domain.entity.user.QUserFile.userFile;


import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionCommentRepositoryImpl implements QuestionCommentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;



    @Override
    public List<QuestionDetailReplyDto> findReplyByQuestionBoardId(Long questionId) {

        return jpaQueryFactory.select(new QQuestionDetailReplyDto(
                questionComment.id,
                questionComment.questionCommentContent,
                questionComment.questionCommentRd,
                questionComment.questionCommentMd,
                users.id,
                users.userAccount,
                users.userNickName,
                userFile.id,
                userFile.route,
                userFile.uuid,
                userFile.name
        ))
                .from(questionComment)
                .leftJoin(questionComment.users,users)
                .leftJoin(users.userFile,userFile)
                .where(questionComment.question.id.eq(questionId))
                .orderBy(questionComment.id.desc())
                .fetch();

    }
}
