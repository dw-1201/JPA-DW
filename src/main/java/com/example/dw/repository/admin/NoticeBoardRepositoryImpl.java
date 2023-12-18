package com.example.dw.repository.admin;


import com.example.dw.domain.dto.admin.NoticeBoardDto;
import com.example.dw.domain.dto.admin.QNoticeBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.dw.domain.entity.admin.QNoticeBoard.noticeBoard;

@Repository
@RequiredArgsConstructor
public class NoticeBoardRepositoryImpl implements NoticeBoardRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;




    @Override
    public Page<NoticeBoardDto> findNoticeListBySearch(Pageable pageable, SearchForm searchForm) {

        List<NoticeBoardDto> content = getNoticeBoardList(pageable, searchForm);
        Long count = getCount(searchForm);

        return new PageImpl<>(content, pageable, count);
    }




    private Long getCount(SearchForm searchForm){

        Long count = jpaQueryFactory
                .select(noticeBoard.count())
                .from(noticeBoard)
                .where(
                        cateKeywordEq(searchForm)
                )
                .fetchOne();
        return count;
    }

    private List<NoticeBoardDto> getNoticeBoardList(Pageable pageable, SearchForm searchForm){

        List<NoticeBoardDto> contents = jpaQueryFactory
                .select(new QNoticeBoardDto(
                        noticeBoard.id,
                        noticeBoard.noticeBoardTitle,
                        noticeBoard.noticeBoardContent,
                        noticeBoard.noticeBoardViewCount,
                        noticeBoard.noticeBoardRd,
                        noticeBoard.noticeBoardMd
                ))
                .from(noticeBoard)
                .where(
                        cateKeywordEq(searchForm)
                )
                .orderBy(noticeBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();



        return contents;
    }


    private BooleanExpression cateKeywordEq(SearchForm searchForm){
        if(StringUtils.hasText(searchForm.getCate())&&StringUtils.hasText(searchForm.getKeyword())){

            switch (searchForm.getCate()){

                case "noticeBoardTitle" :
                    return noticeBoard.noticeBoardTitle.containsIgnoreCase(searchForm.getKeyword());
                case "noticeBoardContent" :
                    return noticeBoard.noticeBoardContent.containsIgnoreCase(searchForm.getKeyword());
                default:
                    break;
            }

        }
        return noticeBoard.id.isNotNull();
    }

}

