package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.QWalkMateDetailDto;
import com.example.dw.domain.dto.community.QWalkMateListDto;
import com.example.dw.domain.dto.community.WalkMateDetailDto;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchCateLocationForm;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.domain.form.SearchLocationForm;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.example.dw.domain.entity.user.QPet.pet;
import static com.example.dw.domain.entity.user.QPetImg.petImg;
import static com.example.dw.domain.entity.user.QUsers.users;
import static com.example.dw.domain.entity.walkingMate.QWalkingMate.walkingMate;
import static com.example.dw.domain.entity.walkingMate.QWalkingMateState.walkingMateState;

@Repository
@RequiredArgsConstructor
public class WalkingMateRepositoryImpl implements WalkingMateRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;


    //산책글 모집현황

    //산책글 리스트
    @Override
    public Page<WalkMateListDto> findAllWalkMate(Pageable pageable, SearchLocationForm searchLocationForm) {

        List<WalkMateListDto> contents = jpaQueryFactory.select(new QWalkMateListDto(
                walkingMate.id,
                walkingMate.walkingMateTitle,
                walkingMate.walkingMateRd,
                walkingMate.walkingMateViewCount,
                walkingMate.walkingMateState,
                walkingMate.walkingMatePerson,
                walkingMateState.count(),
                walkingMate.walkingMateDate,
                walkingMate.walkingMateTime,
                walkingMate.walkCity,
                walkingMate.walkCounty,
                users.id,
                users.userNickName,
                users.userAccount
        ))
                .from(walkingMate)
                .leftJoin(walkingMate.users, users)
                .leftJoin(walkingMate.walkingMateStateList, walkingMateState)
                .where(
                        areaNameEq(searchLocationForm),
                        createRecruitmentStatusCondition(searchLocationForm),
                        cityNameEq(searchLocationForm),
                        countyNameEq(searchLocationForm)
                )
//                .where(walkingMateState.state.eq(1))
                .groupBy(
                        walkingMate.id,
                        walkingMate.walkingMateTitle,
                        walkingMate.walkingMateRd,
                        walkingMate.walkingMateViewCount,
                        walkingMate.walkingMateState,
                        walkingMate.walkingMatePerson,
                        walkingMate.walkingMateDate,
                        walkingMate.walkingMateTime,
                        walkingMate.walkCity,
                        walkingMate.walkCounty,
                        users.id,
                        users.userNickName,
                        users.userAccount
                )
                .orderBy(walkingMate.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();


        Long counts =  jpaQueryFactory.select(
                walkingMate.count()
                )
                .from(walkingMate)
                .where(
                        areaNameEq(searchLocationForm),
                        createRecruitmentStatusCondition(searchLocationForm),
                        cityNameEq(searchLocationForm),
                        countyNameEq(searchLocationForm)
                )
                .fetchOne();



        return new PageImpl<>(contents, pageable, counts);

    }



    //산책글 상세보기
    @Override
    public Optional<WalkMateDetailDto> walkMateDetail(Long walkBoardId) {
        return Optional.ofNullable(jpaQueryFactory.select(new QWalkMateDetailDto(
                walkingMate.id,
                walkingMate.users.id,
                users.userNickName,
                users.userAccount,
                walkingMate.walkingMateRd,
                walkingMate.walkingMateMd,
                walkingMate.walkingMateTitle,
                walkingMate.walkingMateContent,
                walkingMateState.count(),
                walkingMate.walkingMatePerson,
                walkingMate.walkingMateDate,
                walkingMate.walkingMateTime,
                walkingMate.walkingMateFullAddress,
                walkingMate.walkCity,
                walkingMate.walkCounty,
                pet.id,
                pet.name,
                pet.petCategory,
                pet.weight,
                pet.neutering,
                pet.petGender,
                petImg.id,
                petImg.petPath,
                petImg.petUuid,
                petImg.petFileName,
                walkingMate.walkingMateViewCount,
                walkingMate.walkingMateState


        ))
                .from(walkingMate)
                .leftJoin(walkingMate.users, users)
                .leftJoin(walkingMate.pet, pet)
                .leftJoin(pet.petImg, petImg)
                .leftJoin(walkingMate.walkingMateStateList, walkingMateState)
                .where(walkingMate.id.eq(walkBoardId).and(walkingMateState.state.eq(1)))
                .groupBy( walkingMate.id,
                        walkingMate.users.id,
                        users.userNickName,
                        users.userAccount,
                        walkingMate.walkingMateRd,
                        walkingMate.walkingMateMd,
                        walkingMate.walkingMateTitle,
                        walkingMate.walkingMateContent,
                        walkingMate.walkingMatePerson,
                        walkingMate.walkingMateDate,
                        walkingMate.walkingMateTime,
                        walkingMate.walkingMateFullAddress,
                        walkingMate.walkCity,
                        walkingMate.walkCounty,
                        pet.id,
                        pet.name,
                        pet.petCategory,
                        pet.weight,
                        pet.neutering,
                        pet.petGender,
                        petImg.id,
                        petImg.petPath,
                        petImg.petUuid,
                        petImg.petFileName,
                        walkingMate.walkingMateViewCount,
                        walkingMate.walkingMateState
                )
                .fetchOne());
    }



    //관리자 페이지 산책글 리스트
    @Override
    public Page<WalkMateListDto> findAllWalkMate(Pageable pageable, SearchCateLocationForm searchCateLocationForm) {
        List<WalkMateListDto> content = jpaQueryFactory.select(new QWalkMateListDto(
                walkingMate.id,
                walkingMate.walkingMateTitle,
                walkingMate.walkingMateRd,
                walkingMate.walkingMateViewCount,
                walkingMate.walkingMateState,
                walkingMateState.count(),
                walkingMate.walkingMatePerson,
                walkingMate.walkingMateDate,
                walkingMate.walkingMateTime,
                walkingMate.walkCity,
                walkingMate.walkCounty,
                users.id,
                users.userNickName,
                users.userAccount

        ))      .from(walkingMate)
                .leftJoin(walkingMate.users, users)
                .leftJoin(walkingMate.walkingMateStateList, walkingMateState)
                .where(
                        cateKeywordEq(new SearchForm(searchCateLocationForm.getCate(), searchCateLocationForm.getKeyword())),
                        createRecruitmentStatusCondition(new SearchLocationForm(searchCateLocationForm.getCounty(),searchCateLocationForm.getState())),
                        areaNameEq(new SearchLocationForm(searchCateLocationForm.getArea())),
                        cityNameEq(new SearchLocationForm(searchCateLocationForm.getCity())),
                        countyNameEq(new SearchLocationForm(searchCateLocationForm.getCounty())),
                        dateEq(searchCateLocationForm.getStartDate(), searchCateLocationForm.getEndDate())
                )
//                .where(walkingMateState.state.eq(1))
                .groupBy(
                        walkingMate.id,
                        walkingMate.walkingMateTitle,
                        walkingMate.walkingMateRd,
                        walkingMate.walkingMateViewCount,
                        walkingMate.walkingMateState,
                        walkingMate.walkingMatePerson,
                        walkingMate.walkingMateDate,
                        walkingMate.walkingMateTime,
                        walkingMate.walkCity,
                        walkingMate.walkCounty,
                        users.id,
                        users.userNickName,
                        users.userAccount

                )
                .orderBy(walkingMate.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long count = jpaQueryFactory.select(walkingMate.count()
        )
                .from(walkingMate)
                .where(
                        cateKeywordEq(new SearchForm(searchCateLocationForm.getCate(), searchCateLocationForm.getKeyword())),
                        createRecruitmentStatusCondition(new SearchLocationForm(searchCateLocationForm.getCounty(),searchCateLocationForm.getState())),
                        areaNameEq(new SearchLocationForm(searchCateLocationForm.getArea())),
                        cityNameEq(new SearchLocationForm(searchCateLocationForm.getCity())),
                        countyNameEq(new SearchLocationForm(searchCateLocationForm.getCounty())),
                        dateEq(searchCateLocationForm.getStartDate(), searchCateLocationForm.getEndDate())


                )
                .fetchOne();
        return new PageImpl<>(content, pageable, count);

    }

    //산책메이트 리스트 전체-모집중-모집완료
    private BooleanExpression createRecruitmentStatusCondition(SearchLocationForm searchLocationForm) {
        try{
            if (searchLocationForm.getState().equals("0")) { // 모집중
                return walkingMate.walkingMateState.eq(0L);
            } else if (searchLocationForm.getState().equals("1")) { // 모집완료
                return walkingMate.walkingMateState.eq(1L);
            } else { // 전체보기 ('' 인 경우)
                return null; // 특정 조건 없이 모든 결과 반환
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }

    }

    //산책메이트 리스트 권역 검색
    private BooleanExpression areaNameEq(SearchLocationForm searchLocationForm){

        if(searchLocationForm.getArea().equals("수도권")){
            return walkingMate.walkCity.in("서울", "경기", "인천");
        } else if(searchLocationForm.getArea().equals("강원권")){
            return walkingMate.walkCity.eq("강원");
        } else if(searchLocationForm.getArea().equals("충청권")){
            return walkingMate.walkCity.in("충북", "충남", "대전", "세종");
        }   else if(searchLocationForm.getArea().equals("전라권")){
            return walkingMate.walkCity.in("전북", "전남", "광주");
        }   else if(searchLocationForm.getArea().equals("경상권")){
            return walkingMate.walkCity.in("경북", "경남", "부산", "대구", "울산");
        } else if(searchLocationForm.getArea().equals("제주권")){
            return walkingMate.walkCity.eq("제주");
        } else {
            return null;

        }
    }
    //산책메이트 도시 검색
    private BooleanExpression cityNameEq(SearchLocationForm searchLocationForm){
        return StringUtils.hasText(searchLocationForm.getCity()) ? walkingMate.walkCity.eq(searchLocationForm.getCity()) : null;
    }
    //산책메이트 시,군,구 검색
    private BooleanExpression countyNameEq(SearchLocationForm searchLocationForm){
        return StringUtils.hasText(searchLocationForm.getCounty()) ? walkingMate.walkCounty.eq(searchLocationForm.getCounty()) : null;
    }



    //관리자 산책글 제목/내용검색
    private BooleanExpression cateKeywordEq(SearchForm searchForm){
        if(StringUtils.hasText(searchForm.getCate())&&StringUtils.hasText(searchForm.getKeyword())){

            switch (searchForm.getCate()){

                case "walkListTitle" :
                    return walkingMate.walkingMateTitle.containsIgnoreCase(searchForm.getKeyword());
                case "walkListWriter" :
                    return walkingMate.users.userAccount.containsIgnoreCase(searchForm.getKeyword());
                default:
                    break;
            }

        }
        return walkingMate.id.isNotNull();
    }

    //날짜 검색
    private BooleanExpression dateEq(String startDate, String endDate) {

        if ((startDate == "" || startDate == null) && (endDate == "" || endDate == null)) {

            System.out.println("둘다 null이야");
            return null;
        }


        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localStartDate = LocalDate.parse(startDate, formatter);
            LocalDate localEndDate = LocalDate.parse(endDate, formatter);


            LocalDateTime start = localStartDate.atStartOfDay();
            LocalDateTime end = localEndDate.atTime(LocalTime.MAX);


            if (end.isBefore(start)) {

                LocalDateTime temp = end;
                end = start;
                start = temp;
                System.out.println("서로 바껴서 선택했을 때");
                System.out.println("시작날짜" + start);
                System.out.println("종료날짜" + end);
                return Expressions.allOf(walkingMate.walkingMateRd.between(start, end));

            }else if(startDate == null){
                System.out.println("시작날짜가 없어");
                return Expressions.allOf(walkingMate.walkingMateRd.before(end));
            }else if(endDate == null){
                System.out.println("종료날짜가 없어");
                return Expressions.allOf(walkingMate.walkingMateRd.after(start));
            }
            else {
                System.out.println("정상적인 검색");
                return Expressions.allOf(walkingMate.walkingMateRd.between(start, end));
            }
        } catch (DateTimeException e) {
            e.printStackTrace();


        }
        return null;

    }

}
