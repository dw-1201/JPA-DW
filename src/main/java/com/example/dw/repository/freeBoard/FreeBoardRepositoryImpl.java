package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.domain.dto.community.QFreeBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.freeBoard.QFreeBoard.freeBoard;

@Repository
public class FreeBoardRepositoryImpl implements FreeBoardRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    public FreeBoardRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Page<FreeBoardDto> findFreeBoardListBySearch(Pageable pageable, SearchForm searchForm) {

        List<FreeBoardDto> content = getFreeBoardList(pageable, searchForm);
        Long counts = getCount(searchForm);
        return new PageImpl<>(content, pageable, counts);
    }

    private List<FreeBoardDto> getFreeBoardList(Pageable pageable, SearchForm searchForm){

        StringPath cate = searchForm.getCate().equals("freeBoardTitle") ? freeBoard.freeBoardTitle : searchForm.getCate().equals("freeBoardContent") ? freeBoard.freeBoardContent : freeBoard.freeBoardTitle;

        System.out.println("[선택된 카테고리] : "+cate + "===");
        System.out.println("[입력된 검색키워드] :" + searchForm.getKeyword() + "===");

        List<FreeBoardDto> contents = jpaQueryFactory
                .select(new QFreeBoardDto(
                        freeBoard.id,
                        freeBoard.freeBoardTitle,
                        freeBoard.freeBoardContent,
                        freeBoard.freeBoardRd,
                        freeBoard.freeBoardMd,
                        freeBoard.freeBoardViewCount,
                        freeBoard.freeBoardImg,
                        freeBoard.freeBoardComment,
                        freeBoard.freeBoardLike,
                        freeBoard.users // Users 추가
//                        freeBoard.users.userNickName
                ))
                .from(freeBoard)
                .where(cate.like("%"+searchForm.getKeyword() + "%"))
                .orderBy(freeBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        return  contents;
    }


    private Long getCount(SearchForm searchForm){
        Long count = jpaQueryFactory
                .select(freeBoard.count())
                .from(freeBoard)
                .where(freeBoard.freeBoardTitle.like("%" + searchForm.getKeyword()+"%"))
                .fetchOne();
        return  count;
    }

}
