package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.dto.admin.QFaqBoardDto;
import com.example.dw.domain.entity.admin.FaqBoard;
import com.example.dw.domain.entity.admin.QFaqBoard;
import com.example.dw.domain.form.FaqBoardForm;
import com.example.dw.domain.form.SearchFaqForm;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.admin.QFaqBoard.faqBoard;

@Repository
public class FaqBoardRepositoryImpl implements FaqBoardRepositoryCustom{


    private final JPAQueryFactory jpaQueryFactory;

    public FaqBoardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<FaqBoardDto> findFaqListBySearch() {

        List<FaqBoardDto> content = getFaqBoardList();

        return content;

    }

    private List<FaqBoardDto> getFaqBoardList(){
        List<FaqBoardDto> contents = jpaQueryFactory
                .select(new QFaqBoardDto(
                        faqBoard.id,
                        faqBoard.faqBoardTitle,
                        faqBoard.faqBoardContent,
                        faqBoard.faqBoardViewCount,
                        faqBoard.faqBoardRd,
                        faqBoard.faqBoardMd
                ))
                .from(faqBoard)
                .orderBy(faqBoard.id.desc())
                .fetch();

        return contents;
    }
}
