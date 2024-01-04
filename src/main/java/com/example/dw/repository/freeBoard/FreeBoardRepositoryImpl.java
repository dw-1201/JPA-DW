package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardDetailDto;
import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.domain.dto.community.QFreeBoardDetailDto;
import com.example.dw.domain.dto.community.QFreeBoardDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.freeBoard.QFreeBoard.freeBoard;
import static com.example.dw.domain.entity.freeBoard.QFreeBoardImg.freeBoardImg;
import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class FreeBoardRepositoryImpl implements FreeBoardRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<FreeBoardDto> findFreeBoardListBySearch(Pageable pageable, String keyword) {
        System.out.println("-----------------");
        List<FreeBoardDto> content = getFreeBoardList(pageable, keyword);
        Long counts = getCount(keyword);
        return new PageImpl<>(content, pageable, counts);
    }

    @Override
    public List<FreeBoardDetailDto> findFreeBoardById(Long id) {
        return jpaQueryFactory
                .select(new QFreeBoardDetailDto(
                        freeBoard.id,
                        freeBoard.freeBoardTitle,
                        freeBoard.freeBoardContent,
                        freeBoard.freeBoardRd,
                        freeBoard.freeBoardMd,
                        freeBoard.freeBoardViewCount,
                        freeBoardImg.id,
                        freeBoardImg.freeBoardImgRoute,
                        freeBoardImg.freeBoardImgName,
                        freeBoardImg.freeBoardImgUuid,
                        freeBoard.users.id,
                        freeBoard.users.userAccount,
                        freeBoard.users.userNickName
                ))
                .from(freeBoard)
                .leftJoin(freeBoardImg).on(freeBoard.id.eq(freeBoardImg.freeBoard.id))
                .leftJoin(freeBoard.users).on(freeBoard.users.id.eq(users.id))
                .where(freeBoard.id.eq(id))
                .fetch();
    }

    private List<FreeBoardDto> getFreeBoardList(Pageable pageable, String keyword) {
        return jpaQueryFactory
                .select(new QFreeBoardDto(
                        freeBoard.id,
                        freeBoard.freeBoardTitle,
                        freeBoard.freeBoardContent,
                        freeBoard.freeBoardRd,
                        freeBoard.freeBoardMd,
                        freeBoard.freeBoardViewCount,
                        freeBoard.freeBoardCommentCount,
                        freeBoardImg.id,
                        freeBoardImg.freeBoardImgRoute,
                        freeBoardImg.freeBoardImgName,
                        freeBoardImg.freeBoardImgUuid,
                        users.id,
                        users.userAccount,
                        users.userNickName
                ))
                .from(freeBoard)
                .leftJoin(freeBoard.freeBoardImg, freeBoardImg)
                .leftJoin(freeBoard.users, users)
                .where(freeBoard.freeBoardTitle.containsIgnoreCase(keyword)
                        .or(freeBoard.freeBoardContent.containsIgnoreCase(keyword)))
                .orderBy(freeBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

//    @Override
//    public Page<FreeBoardDto> findFreeBoardListBySearchAndSort(Pageable pageable, String keyword, String sort) {
//        QueryResults<FreeBoardDto> queryResults = jpaQueryFactory
//            .select(new QFreeBoardDto(
//                    freeBoard.id,
//                    freeBoard.freeBoardTitle,
//                    freeBoard.freeBoardContent,
//                    freeBoard.freeBoardRd,
//                    freeBoard.freeBoardMd,
//                    freeBoard.freeBoardViewCount,
//                    freeBoard.freeBoardCommentCount,
//                    freeBoardImg.id,
//                    freeBoardImg.freeBoardImgRoute,
//                    freeBoardImg.freeBoardImgName,
//                    freeBoardImg.freeBoardImgUuid,
//                    users.id,
//                    users.userAccount,
//                    users.userNickName
//            ))
//                .from(freeBoard)
//                .leftJoin(freeBoard.freeBoardImg, freeBoardImg)
//                .leftJoin(freeBoard.users, users)
//                .where(freeBoard.freeBoardTitle.containsIgnoreCase(keyword)
//                        .or(freeBoard.freeBoardContent.containsIgnoreCase(keyword)))
//                .orderBy(getOrderSpecifier(sort))
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetchResults();
//
//        List<FreeBoardDto> content = queryResults.getResults();
//        long count = queryResults.getTotal();
//
//        return new PageImpl<>(content, pageable, count);
//    }
//
//    private OrderSpecifier<?> getOrderSpecifier(String sort) {
//        if ("recent".equals(sort)) {
//            return freeBoard.freeBoardMd.desc(); // 최신순
//        } else if ("reply".equals(sort)) {
//            return freeBoard.freeBoardCommentCount.desc(); // 댓글순
//        } else {
//            return freeBoard.freeBoardViewCount.desc(); // 인기순 (기본값)
//        }
//    }

    private Long getCount(String keyword) {
        Long count = jpaQueryFactory
                .select(freeBoard.count())
                .from(freeBoard)
                .where(
                        freeBoard.freeBoardTitle.containsIgnoreCase(keyword)
                                .or(freeBoard.freeBoardContent.containsIgnoreCase(keyword))
                )
                .fetchOne();
        return count;
    }




    // 마이페이지 해당 유저 작성글 조회

    private Long getMyFerrboardCount(Long userId) {
        Long count = jpaQueryFactory
                .select(freeBoard.count())
                .from(freeBoard)
                .where(freeBoard.users.id.eq(userId))
                .fetchOne();
        return count;
    }



    private List<FreeBoardDto> getMyFreeBoardList(Pageable pageable, Long userId) {
        return jpaQueryFactory
                .select(new QFreeBoardDto(
                        freeBoard.id,
                        freeBoard.freeBoardTitle,
                        freeBoard.freeBoardContent,
                        freeBoard.freeBoardRd,
                        freeBoard.freeBoardMd,
                        freeBoard.freeBoardViewCount,
                        freeBoard.freeBoardCommentCount,
                        freeBoardImg.id,
                        freeBoardImg.freeBoardImgRoute,
                        freeBoardImg.freeBoardImgName,
                        freeBoardImg.freeBoardImgUuid,
                        users.id,
                        users.userAccount,
                        users.userNickName
                ))
                .from(freeBoard)
                .leftJoin(freeBoard.freeBoardImg, freeBoardImg)
                .where(freeBoard.users.id.eq(userId))
                .orderBy(freeBoard.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    @Override
    public Page<FreeBoardDto> findFreeBoardListById(Pageable pageable, Long userId) {


        List<FreeBoardDto> content = getMyFreeBoardList(pageable, userId);
        Long counts = getMyFerrboardCount(userId);
        return new PageImpl<>(content, pageable, counts);

    }
}