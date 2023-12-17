package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.dto.admin.QFaqBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

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

        Long count = jpaQueryFactory
                .select(faqBoard.count())
                .from(faqBoard)
                .where(
                        cateKeywordEq(searchForm)

                )
                .fetchOne();
        return count;
    }

    private List<FaqBoardDto> getFaqBoardList(Pageable pageable, SearchForm searchForm){

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
                .where(

                        cateKeywordEq(searchForm)
                )
                .orderBy(faqBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return contents;
    }


    private BooleanExpression cateKeywordEq(SearchForm searchForm){
        if(StringUtils.hasText(searchForm.getCate())&&StringUtils.hasText(searchForm.getKeyword())){
            switch (searchForm.getCate()){
                case "faqBoardTitle" :
                    return faqBoard.faqBoardTitle.containsIgnoreCase(searchForm.getKeyword());
                case "faqBoardContent" :
                    return faqBoard.faqBoardContent.containsIgnoreCase(searchForm.getKeyword());
                default:
                    break;
            }

        }
        return faqBoard.id.isNotNull();
    }

}
