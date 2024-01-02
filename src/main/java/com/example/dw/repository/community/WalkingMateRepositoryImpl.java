package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.*;
import com.example.dw.domain.form.SearchForm;
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

        List<WalkMateListDto> contents = Optional.ofNullable(jpaQueryFactory.select(new QWalkMateListDto(
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
                users.userAccount,
                walkingMate.walkingMateState
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
                .where(walkingMateState.state.eq(1))
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
                        users.userAccount,
                        walkingMate.walkingMateState
                )
                .orderBy(walkingMate.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()).orElseThrow(()->{throw new IllegalArgumentException("조회정보없음");});


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

    //산책 신청자 펫 정보
    @Override
    public List<WalkDetailStateDto> applierPetsInfo(Long walkMateId) {

        return jpaQueryFactory.select(new QWalkDetailStateDto(

                walkingMateState.walkingMate.id,
                walkingMateState.id,
                walkingMateState.users.id,
                walkingMateState.pet.id,
                walkingMateState.pet.name,
                walkingMateState.pet.weight,
                walkingMateState.pet.petGender,
                walkingMateState.pet.birthDate,
                walkingMateState.pet.petCategory,
                walkingMateState.pet.neutering,
                pet.petImg.get(0).petFileName,
                pet.petImg.get(0).petPath,
                pet.petImg.get(0).petUuid,
                walkingMateState.state

        ))
                .from(walkingMateState)
                .leftJoin(walkingMateState.walkingMate, walkingMate)
                .leftJoin(walkingMateState.users, users)
                .leftJoin(walkingMateState.pet, pet)
                .leftJoin(pet.petImg, petImg)
                .where(walkingMateState.walkingMate.id.eq(walkMateId))
                .fetch();
    }


    //관리자 페이지 산책글 리스트
    @Override
    public Page<WalkMateListDto> findAllWalkMate(Pageable pageable, SearchForm searchForm) {
        List<WalkMateListDto> content = Optional.ofNullable(jpaQueryFactory.select(new QWalkMateListDto(
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
                users.userAccount,
                walkingMate.walkingMateState

        ))      .from(walkingMate)
                .leftJoin(walkingMate.users, users)
                .where(
                        cateKeywordEq(searchForm)
                )
                .where(walkingMateState.state.eq(1))
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
                        users.userAccount,
                        walkingMate.walkingMateState

                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch()).orElseThrow(()->{throw new IllegalArgumentException("조회정보 없음");});

        Long count = jpaQueryFactory.select(walkingMate.count()
        )
                .from(walkingMate)
                .where(                        cateKeywordEq(searchForm)

                )
                .fetchOne();
        System.out.println(content.toString()+"#########################");
        return new PageImpl<>(content, pageable, count);

    }

    //산책메이트 리스트 전체-모집중-모집완료
    private BooleanExpression createRecruitmentStatusCondition(SearchLocationForm searchLocationForm) {
        if (searchLocationForm.getState().equals("0")) { // 모집중
            return walkingMate.walkingMateState.eq(0L);
        } else if (searchLocationForm.getState().equals("1")) { // 모집완료
            return walkingMate.walkingMateState.eq(1L);
        } else { // 전체보기 ('' 인 경우)
            return null; // 특정 조건 없이 모든 결과 반환
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


}
