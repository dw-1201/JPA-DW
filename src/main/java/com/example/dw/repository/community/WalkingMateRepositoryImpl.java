package com.example.dw.repository.community;

import com.example.dw.domain.dto.admin.AdminWalkMateDetailDto;
import com.example.dw.domain.dto.admin.ApplierUserList;
import com.example.dw.domain.dto.admin.QAdminWalkMateDetailDto;
import com.example.dw.domain.dto.admin.QApplierUserList;
import com.example.dw.domain.dto.community.*;
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
import static com.example.dw.domain.entity.user.QUserFile.userFile;
import static com.example.dw.domain.entity.user.QUsers.users;
import static com.example.dw.domain.entity.walkingMate.QWalkingMate.walkingMate;
import static com.example.dw.domain.entity.walkingMate.QWalkingMateComment.walkingMateComment;
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



        SearchLocationForm searchLocationForm = new SearchLocationForm(
                searchCateLocationForm.getArea(),
                searchCateLocationForm.getCity(),
                searchCateLocationForm.getCounty(),
                searchCateLocationForm.getState()
        );


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
                        createRecruitmentStatusCondition(searchLocationForm),
                        areaNameEq(searchLocationForm),
                        cityNameEq(searchLocationForm),
                        countyNameEq(searchLocationForm),
                        dateEq(searchCateLocationForm.getStartDate(), searchCateLocationForm.getEndDate())
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
                        createRecruitmentStatusCondition(searchLocationForm),
                        areaNameEq(searchLocationForm),
                        cityNameEq(searchLocationForm),
                        countyNameEq(searchLocationForm),
                        dateEq(searchCateLocationForm.getStartDate(), searchCateLocationForm.getEndDate())


                )
                .fetchOne();
        return new PageImpl<>(content, pageable, count);

    }


    //관리자페이지 산책글 상세보기
    @Override
    public AdminWalkMateDetailDto adminWalkMateDetail(Long walkMateId) {

        AdminWalkMateDetailDto adminWalkMateDetailDto = jpaQueryFactory.select(
                new QAdminWalkMateDetailDto(
                        walkingMate.id,
                        walkingMate.users.id,
                        walkingMate.users.userAccount,
                        walkingMate.walkingMateRd,
                        walkingMate.walkingMateMd,
                        walkingMate.walkingMateViewCount,
                        walkingMate.walkingMateTitle,
                        walkingMate.walkingMateContent,
                        walkingMate.walkingMateFullAddress,
                        walkingMate.walkingMateDate,
                        walkingMate.walkingMateTime,
                        pet.id,
                        pet.name,
                        walkingMate.walkingMateState
                )).from(walkingMate)
                .leftJoin(walkingMate.users, users)
                .leftJoin(users.pet, pet)
                 .where(walkingMate.id.eq(walkMateId))
                 .fetchOne();

        List<ApplierUserList> applierUserListList = jpaQueryFactory.select(new QApplierUserList(
                                walkingMateState.id,
                               walkingMateState.users.id,
                                walkingMateState.users.userAccount,
                                pet.id,
                                pet.petCategory,
                                pet.name,
                                pet.weight,
                                pet.petGender,
                                pet.neutering,
                                pet.birthDate,
                                petImg.petPath,
                                petImg.petUuid,
                                petImg.petFileName,
                                walkingMateState.state
                ))
                .from(walkingMateState)
                .leftJoin(walkingMateState.users, users)
                .leftJoin(walkingMateState.pet, pet)
                .leftJoin(pet.petImg, petImg)
                .where(walkingMate.id.eq(walkMateId).and(walkingMateState.writerCheck.eq(0)))
                .fetch();

        List<WalkMateDetailReplyDto> replyDtos =
                       jpaQueryFactory.select(new QWalkMateDetailReplyDto(
                                walkingMateComment.id,
                                walkingMateComment.walkingMateCommentContent,
                                walkingMateComment.walkingMateCommentRd,
                                walkingMateComment.walkingMateCommentMd,
                                walkingMateComment.users.id,
                                walkingMateComment.users.userAccount,
                                walkingMateComment.users.userNickName,
                                userFile.id,
                                userFile.route,
                                userFile.uuid,
                                userFile.name
                        ))
                               .from(walkingMateComment)
                               .leftJoin(walkingMateComment.walkingMate, walkingMate)
                               .leftJoin(walkingMateComment.users, users)
                               .leftJoin(users.userFile, userFile)
                               .where(walkingMateComment.walkingMate.id.eq(walkMateId))
                               .fetch();

        adminWalkMateDetailDto.setApplierUserListList(applierUserListList);
        adminWalkMateDetailDto.setWalkMateDetailReplyDtos(replyDtos);

        return adminWalkMateDetailDto;
    }

    //메인페이지 산책글 리스트
    @Override
    public List<IndexWalkMateDto> IndexWalkMateList() {
        return jpaQueryFactory.select(new QIndexWalkMateDto(
                walkingMate.id,
                walkingMate.walkCity,
                walkingMate.walkCounty,
                walkingMate.walkingMateTitle,
                walkingMate.walkingMateState,
                users.id,
                petImg.petPath,
                petImg.petUuid,
                petImg.petFileName
        ))
                .from(walkingMate)
                .leftJoin(walkingMate.users, users)
                .leftJoin(walkingMate.pet, pet)
                .leftJoin(pet.petImg, petImg)
                .where(walkingMate.walkingMateState.eq(0L))
                .orderBy(walkingMate.id.desc())
                .limit(7)
                .fetch();
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

        if ((startDate == null || startDate.isEmpty()) && (endDate == null || endDate.isEmpty())) {
            System.out.println("둘 다 null이야");
            return null;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime start = null;
        LocalDateTime end = null;

        try {
            if (!startDate.isEmpty()) {
                LocalDate localStartDate = LocalDate.parse(startDate, formatter);
                start = localStartDate.atStartOfDay();
            }

            if (!endDate.isEmpty()) {
                LocalDate localEndDate = LocalDate.parse(endDate, formatter);
                end = localEndDate.atTime(LocalTime.MAX);
            }

            if (start != null && end != null && end.isBefore(start)) {
                LocalDateTime temp = end;
                end = start;
                start = temp;
                System.out.println("서로 바껴서 선택했을 때");
                System.out.println("시작날짜" + start);
                System.out.println("종료날짜" + end);
            }

            if (start != null && end != null) {
                System.out.println("정상적인 검색");
                return Expressions.allOf(walkingMate.walkingMateRd.between(start, end));
            } else if (start != null) {
                System.out.println("종료날짜가 없어");
                return Expressions.allOf(walkingMate.walkingMateRd.after(start));
            } else if (end != null) {
                System.out.println("시작날짜가 없어");
                return Expressions.allOf(walkingMate.walkingMateRd.before(end));
            }
        } catch (DateTimeException e) {
            e.printStackTrace();
        }

        return null;
    }

}
