package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.QWalkMateListDto;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchLocationForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.dw.domain.entity.user.QUsers.users;
import static com.example.dw.domain.entity.walkingMate.QWalkingMate.walkingMate;

@Repository
@RequiredArgsConstructor
public class WalkingMateRepositoryImpl implements WalkingMateRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;



    @Override
    public Page<WalkMateListDto> findAllWalkMate(Pageable pageable, SearchLocationForm searchLocationForm) {

        List<WalkMateListDto> contents = getWalkMateList(pageable, searchLocationForm);
        Long counts = getCount(searchLocationForm);

        return new PageImpl<>(contents, pageable, counts);

    }



    private Long getCount(SearchLocationForm searchLocationForm){
        return jpaQueryFactory.select(
                walkingMate.count()
        )
                .from(walkingMate)
                .where(
                        createRecruitmentStatusCondition(searchLocationForm),
                        cityNameEq(searchLocationForm),
                        countyNameEq(searchLocationForm)
                )
                .fetchOne();
    }

    private List<WalkMateListDto> getWalkMateList(Pageable pageable, SearchLocationForm searchLocationForm){
        return jpaQueryFactory.select(new QWalkMateListDto(
                walkingMate.id,
                walkingMate.walkingMateTitle,
                walkingMate.walkingMateRd,
                walkingMate.walkingMateViewCount,
                walkingMate.walkingMateState,
                walkingMate.walkingMatePerson,
                walkingMate.walkingMateToday,
                walkingMate.walkingMateDate,
                walkingMate.walkingMateTime,
                walkingMate.walkCity,
                walkingMate.walkCounty,
                users.id,
                users.userNickName
        ))
                .from(walkingMate)
                .leftJoin(walkingMate.users, users)
                .where(
                        createRecruitmentStatusCondition(searchLocationForm),
                        cityNameEq(searchLocationForm),
                        countyNameEq(searchLocationForm)
                )
                .orderBy(walkingMate.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

    }

    private BooleanExpression createRecruitmentStatusCondition(SearchLocationForm searchLocationForm) {
        if (searchLocationForm.getState().equals("0")) { // 모집중
            return walkingMate.walkingMateToday.ne(walkingMate.walkingMatePerson);
        } else if (searchLocationForm.getState().equals("1")) { // 모집완료
            return walkingMate.walkingMateToday.eq(walkingMate.walkingMatePerson);
        } else { // 전체보기 ('' 인 경우)
            return null; // 특정 조건 없이 모든 결과 반환
        }
    }

    private BooleanExpression cityNameEq(SearchLocationForm searchLocationForm){
        return StringUtils.hasText(searchLocationForm.getCity()) ? walkingMate.walkCity.eq(searchLocationForm.getCity()) : null;
    }

    private BooleanExpression countyNameEq(SearchLocationForm searchLocationForm){
        return StringUtils.hasText(searchLocationForm.getCounty()) ? walkingMate.walkCounty.eq(searchLocationForm.getCounty()) : null;
    }


}
