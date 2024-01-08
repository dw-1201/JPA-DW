package com.example.dw.repository.community;


import com.example.dw.domain.dto.community.QWalkMateMyApplicationListDto;
import com.example.dw.domain.dto.community.WalkMateMyApplicationListDto;
import com.example.dw.domain.form.SearchRecruitmentForm;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.walkingMate.QWalkingMateState.walkingMateState;
import static com.example.dw.domain.entity.walkingMate.QWalkingMate.walkingMate;
import static com.example.dw.domain.entity.user.QUsers.users;
import static com.example.dw.domain.entity.user.QPet.pet;
import static com.example.dw.domain.entity.user.QPetImg.petImg;

@Repository
@RequiredArgsConstructor
public class WalkingMateStateRepositoryImpl implements WalkingMateStateRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

//    @Override
//    public Page<WalkMateMyApplicationListDto> findAllWalkingMateStateAndUserId(Pageable pageable, Long userId) {
//
//        List<WalkMateMyApplicationListDto> result = jpaQueryFactory.
//                select(new QWalkMateMyApplicationListDto(
//                        walkingMateState.id,
//                        walkingMateState.state,
//                        walkingMateState.writerCheck,
//                        walkingMate.id,
//                        walkingMate.walkingMateTitle,
//                        walkingMate.walkingMateContent,
//                        walkingMate.walkingMateRd,
//                        walkingMate.walkingMateViewCount,
//                        walkingMate.walkingMateState,
//                        walkingMate.walkingMatePerson,
//                        walkingMate.count(),
//                        walkingMate.walkingMateDate,
//                        walkingMate.walkingMateTime,
//                        walkingMate.walkCity,
//                        walkingMate.walkCounty,
//                        walkingMateState.users.id,
//                        walkingMateState.users.userNickName,
//                        walkingMateState.users.userAccount,
//                        pet.id,
//                        petImg.id,
//                        petImg.petFileName,
//                        petImg.petPath,
//                        petImg.petUuid
//
//                ))
//                .from(walkingMateState)
//                .leftJoin(walkingMateState.walkingMate,walkingMate)
//                .leftJoin(walkingMateState.walkingMate.pet,pet)
//                .leftJoin(walkingMateState.walkingMate.pet.petImg,petImg)
//                .where(
//                        walkingMateState.writerCheck.eq(0) ,
//                        walkingMateState.writerCheck.eq(1),
//                        walkingMateState.users.id.eq(userId)
//                )
//                .groupBy(walkingMateState.id,
//                        walkingMateState.state,
//                        walkingMateState.writerCheck,
//                        walkingMate.id,
//                        walkingMate.walkingMateTitle,
//                        walkingMate.walkingMateContent,
//                        walkingMate.walkingMateRd,
//                        walkingMate.walkingMateViewCount,
//                        walkingMate.walkingMateState,
//                        walkingMate.walkingMatePerson,
//                        walkingMate.walkingMateDate,
//                        walkingMate.walkingMateTime,
//                        walkingMate.walkCity,
//                        walkingMate.walkCounty,
//                        walkingMateState.users.id,
//                        walkingMateState.users.userNickName,
//                        walkingMateState.users.userAccount,
//                        pet.id,
//                        petImg.id,
//                        petImg.petFileName,
//                        petImg.petPath,
//                        petImg.petUuid
//                )
//
//                .orderBy(walkingMate.id.desc())
//                .offset(pageable.getOffset())
//                .limit(pageable.getPageSize())
//                .fetch();
//
//
//        Long counts =  jpaQueryFactory.select(
//                walkingMateState.count()
//        )
//                .from(walkingMate)
//                .where(
//
//                        walkingMateState.users.id.eq(userId)
//
//                )
//                .fetchOne();
//
//        System.out.println(result + " 내가 신청한 메이트 입니다.");
//
//
//        return new PageImpl<>(result, pageable, counts);
//    }

}
