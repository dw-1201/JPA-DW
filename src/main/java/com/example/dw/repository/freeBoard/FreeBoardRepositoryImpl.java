package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.domain.dto.community.QFreeBoardDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.freeBoard.QFreeBoard.freeBoard;

@Repository
@RequiredArgsConstructor
public class FreeBoardRepositoryImpl implements FreeBoardRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
//    private final EntityManager em;

    @Override
    public Page<FreeBoardDto> findFreeBoardListBySearch(Pageable pageable, String keyword) {
        System.out.println("-----------------");
        List<FreeBoardDto> content = getFreeBoardList(pageable, keyword);
        Long counts = getCount(keyword);
        return new PageImpl<>(content, pageable, counts);
    }

    private List<FreeBoardDto> getFreeBoardList(Pageable pageable, String keyword){

        System.out.println("[입력된 검색키워드] :" + keyword + "===");

        System.out.println("---------------123123123");
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
                    freeBoard.users.id,
                    freeBoard.users.userAccount,
                    freeBoard.users.userNickName
            ))
                .from(freeBoard)
                .leftJoin(freeBoard.users) // 수정된 부분: Left Join으로 사용자 정보 가져오기
                .orderBy(freeBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


        return  contents;
    }

    private Long getCount(String keyword){
        Long count = jpaQueryFactory
                .select(freeBoard.count())
                .from(freeBoard)
                .fetchOne();
        return  count;
    }
}