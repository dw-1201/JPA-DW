package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.domain.dto.community.QFreeBoardDto;
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
                    freeBoard.users
            ))
                .from(freeBoard)
                .leftJoin(freeBoard.users) // 수정된 부분: Left Join으로 사용자 정보 가져오기
                .orderBy(freeBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

            contents.forEach(r->
                            System.out.println(r.getId()+"============")
                    );
        System.out.println("================");
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



//
//private List<FreeBoardDto> getFreeBoardList(Pageable pageable, String keyword) {
//    List<FreeBoardDto> contents = jpaQueryFactory
//            .select(new QFreeBoardDto(
//                    freeBoard.id,
//                    freeBoard.freeBoardTitle,
//                    freeBoard.freeBoardContent,
//                    freeBoard.freeBoardRd,
//                    freeBoard.freeBoardMd,
//                    freeBoard.freeBoardViewCount,
//                    freeBoard.freeBoardImg,
//                    freeBoard.freeBoardComment,
//                    freeBoard.freeBoardLike,
//                    freeBoard.users
//            ))
//            .from(freeBoard)
//            .leftJoin(freeBoard.users)
//            .where(
//                    // 검색어가 비어있지 않으면서 해당 필드에 검색어가 포함되어 있는 경우에만 조건 추가
//                    keyword != null && !keyword.isEmpty() ?
//                            freeBoard.freeBoardTitle.contains(keyword)
//                                    .or(freeBoard.freeBoardContent.contains(keyword))
//                            : null
//            )
//            .orderBy(freeBoard.id.desc())
//            .offset(pageable.getOffset())
//            .limit(pageable.getPageSize())
//            .fetch();
//
//    return contents;
//}
//    private Long getCount(String keyword) {
//        Long count = jpaQueryFactory
//                .select(freeBoard.count())
//                .from(freeBoard)
//                .where(
//                        keyword != null && !keyword.isEmpty() ?
//                                freeBoard.freeBoardTitle.contains(keyword)
//                                        .or(freeBoard.freeBoardContent.contains(keyword))
//                                : null
//                )
//                .fetchOne();
//        return count != null ? count : 0L;
//    }