package com.example.dw.repository.admin;


import com.example.dw.domain.dto.admin.NoticeBoardDto;
import com.example.dw.domain.dto.admin.QNoticeBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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
        StringPath cate = searchForm.getCate().equals("noticeBoardTitle") ? noticeBoard.noticeBoardTitle : searchForm.getCate().equals("noticeBoardContent") ? noticeBoard.noticeBoardContent : noticeBoard.noticeBoardTitle;

        Long count = jpaQueryFactory
                .select(noticeBoard.count())
                .from(noticeBoard)
                .where(cate.like("%" + searchForm.getKeyword() +"%"))
                .fetchOne();
        return count;
    }

    private List<NoticeBoardDto> getNoticeBoardList(Pageable pageable, SearchForm searchForm){
        StringPath cate = searchForm.getCate().equals("noticeBoardTitle") ? noticeBoard.noticeBoardTitle : searchForm.getCate().equals("noticeBoardContent") ? noticeBoard.noticeBoardContent : noticeBoard.noticeBoardTitle;

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
                .where(cate.like("%" + searchForm.getKeyword()+"%"))
                .orderBy(noticeBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();



        return contents;
    }
}

