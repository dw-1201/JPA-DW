package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardCommentDto;
import com.example.dw.domain.dto.community.QFreeBoardCommentDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.freeBoard.QFreeBoardComment.freeBoardComment;

@Repository
@RequiredArgsConstructor
public class FreeBoardCommentRepositoryImpl implements FreeBoardCommentCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private FreeBoardCommentRepository freeBoardCommentRepository;

    @Override
    public List<FreeBoardCommentDto> findFreeBoardCommentsByFreeBoardId(Long freeBoardId)
    {
        return findReplies(freeBoardId);
    }


    private List<FreeBoardCommentDto> findReplies(Long freeBoardId){
        return jpaQueryFactory.select(new QFreeBoardCommentDto(
                freeBoardComment.id,
                freeBoardComment.freeBoardCommentContent,
                freeBoardComment.freeBoardCommentRd,
                freeBoardComment.freeBoardCommentMd,
                freeBoardComment.freeBoard.id,
                freeBoardComment.users.id
        ))
                .from(freeBoardComment)
                .orderBy(freeBoardComment.id.desc())
                .where(freeBoardComment.freeBoard.id.eq(freeBoardId))
                .fetch();
    }
}
