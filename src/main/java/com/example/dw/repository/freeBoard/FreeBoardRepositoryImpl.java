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
                        freeBoard.users.id,  //users.id로 직접 사용
                        freeBoard.users.userAccount,
                        freeBoard.users.userNickName
                ))
                .from(freeBoard)
                .leftJoin(freeBoardImg).on(freeBoard.id.eq(freeBoardImg.freeBoard.id))
                .leftJoin(freeBoard.users).on(freeBoard.users.id.eq(users.id))
                .where(freeBoard.id.eq(id))
                .fetch();
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
                .leftJoin(freeBoard.users,users) // 수정된 부분: Left Join으로 사용자 정보 가져오기
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