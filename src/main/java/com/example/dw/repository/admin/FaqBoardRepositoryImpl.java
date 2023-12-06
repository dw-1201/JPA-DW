package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.dto.admin.QFaqBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<FaqBoardDto> findFaqListBySearch(Pageable pageable, SearchForm searchForm) {


        List<FaqBoardDto> content = getFaqBoardList(pageable, searchForm);
        Long counts = getCount(searchForm);
        return new PageImpl<>(content, pageable, counts);

    }

    private Long getCount(SearchForm searchForm){
        StringPath cate = searchForm.getCate().equals("faqTitle") ? faqBoard.faqBoardTitle : searchForm.getCate().equals("faqContent") ? faqBoard.faqBoardContent : faqBoard.faqBoardTitle;

        Long count = jpaQueryFactory
                .select(faqBoard.count())
                .from(faqBoard)
                .where(cate.like("%" + searchForm.getKeyword()+"%"))
                .fetchOne();
        return count;
    }

    private List<FaqBoardDto> getFaqBoardList(Pageable pageable, SearchForm searchForm){


        //셀렉트 검색 카테고리가 faqTitle과 일치하면 faqBoardTitle로 where절
        //faqContent와 일치하면 faqBoardContent로 where절에 입력
        StringPath cate = searchForm.getCate().equals("faqTitle") ? faqBoard.faqBoardTitle : searchForm.getCate().equals("faqContent") ? faqBoard.faqBoardContent : faqBoard.faqBoardTitle;

        System.out.println("[선택된 카테고리] : "+cate + "===");
        System.out.println("[입력된 검색키워드] :" + searchForm.getKeyword() + "===");

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
                .where(cate.like("%" + searchForm.getKeyword() + "%"))
                .orderBy(faqBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return contents;
    }
}
