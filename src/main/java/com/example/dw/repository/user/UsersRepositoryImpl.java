package com.example.dw.repository.user;

import com.example.dw.domain.dto.admin.*;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.dw.domain.entity.freeBoard.QFreeBoard.freeBoard;
import static com.example.dw.domain.entity.question.QQuestion.question;
import static com.example.dw.domain.entity.user.QUsers.users;
import static com.example.dw.domain.entity.user.QUserFile.userFile;

@Repository
@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<UserListDto> findByAll(Pageable pageable, String cate, String keyword, String userState) {

        List<UserListDto> content = getUserList(pageable, cate, keyword ,userState);
        Long counts = getCount(cate, keyword ,userState);

        return new PageImpl<>(content, pageable, counts);
    }

    @Override
    public Optional<UserDetailDto> findByUserId(Long userId) {
        System.out.println(userId);
        UserDetailDto detail = getUserDetail(userId);
        System.out.println(detail.getUserName()+"입니다.");
        return Optional.ofNullable(detail);
    }

    @Override
    public List<AdminUserChartDto> findJoinCountByAll() {
        return getDailyJoinCount();
    }

    @Override
    public Map<String, List> newUserStatus() {
        return getUserStatsBy();
    }


    private Long getCount(String cate, String keyword, String userState){
        return jpaQueryFactory.select(users.count())
                .from(users)
                .where(
                        userStateEq(userState),
                        cateEq(cate, keyword)
                )
                .fetchOne();
    }






    //회원리스트
    private List<UserListDto> getUserList(Pageable pageable, String cate, String keyword, String userState){
        return jpaQueryFactory.select(new QUserListDto(
                users.id,
                users.userAccount,
                users.userName,
                users.userEmail,
                users.userPhone,
                users.userState,
                freeBoard.count(),
                question.count()

        ))
                .from(users)
                .leftJoin(users.freeBoard, freeBoard)
                .leftJoin(users.questions, question)
                .where(
                        userStateEq(userState),
                        cateEq(cate, keyword)
                )
                .groupBy(users.id, users.userAccount, users.userName, users.userEmail, users.userPhone, users.userState)
                .orderBy(users.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

    }

    //회원 상세 정보
    private UserDetailDto getUserDetail(Long userId){
        return jpaQueryFactory.select(new QUserDetailDto(
                users.id,
                users.userAccount,
                users.userName,
                users.userNickName,
                users.userPhone,
                users.userEmail,
                users.userJoinDate,
                users.address.zipCode,
                users.address.address,
                users.address.detail,
                users.userIntroduction,
                users.userFile.id,
                users.userFile.route,
                users.userFile.name,
                users.userFile.uuid
        ))
                .from(users)
                .leftJoin(users.userFile,userFile)
                .where(users.id.eq(userId))
                .fetchOne();
    }



    //주단위 일별 회원가입자 수
    public List<AdminUserChartDto> getDailyJoinCount() {
        LocalDate endDate = LocalDate.now(); // 현재 날짜
        LocalDate startDate = endDate.minusWeeks(1); // 일주일 전 날짜

        // 일주일 간의 날짜 목록 생성
        List<LocalDate> datesInRange = startDate.datesUntil(endDate.plusDays(1))
                .collect(Collectors.toList());

        Map<LocalDate, Long> dailyCounts = jpaQueryFactory
                .select(users.userJoinDate, users.count())
                .from(users)
                .where(users.userJoinDate.between(startDate, endDate))
                .orderBy(users.userJoinDate.desc())
                .groupBy(users.userJoinDate)
                .fetch()
                .stream()
                .collect(Collectors.toMap(
                        //튜플로 반환되므로 튜플에서 꺼내서 Map으로 감싸준다.
                        tuple -> tuple.get(users.userJoinDate),
                        tuple -> tuple.get(users.count()),
                        (count1, count2) -> count1 + count2 
                        //동일한 날짜값이 있으면 duplicate 에러 발생
                        //count1은 날짜 , count2는 새로운 데이터값이다.
                        //에러 방지를 위해 두 값을 서로 합쳐준다. -> 즉 카운트 합산
                ));

        //위에서 생성한 일주일 간 날짜를 가져온다.(datesInRange)
        // 빈 값을 가진 날짜에 대한 결과 추가
        for (LocalDate date : datesInRange) {
            dailyCounts.putIfAbsent(date, 0L);
        }

        //메소드의 반환타입인 List<AdminUserChartDto>에 맞추기위해 entrySet().map()을 이용하여 변환한다.
        return dailyCounts.entrySet().stream()
                .map(entry -> new AdminUserChartDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }






    private Map<String, List> getUserStatsBy() {
        LocalDate nowDate = LocalDate.now();

        //신규 가입 회원 현황
        List<UserRecentJoinDto> recentJoinDtoList = jpaQueryFactory.select(new QUserRecentJoinDto(
                users.id,
                users.userAccount,
                users.userName,
                users.userEmail,
                users.userPhone,
                users.userJoinDate

        ))
                .from(users)
                .orderBy(users.id.desc())
                .limit(4)
                .where()
                .fetch();

        //전체 가입자 수
        Long totalCount = jpaQueryFactory.select(
                users.count()
        )
                .from(users)
                .fetchOne();

        //당일 가입 회원 수
        Long joinCount = jpaQueryFactory.select(
                users.count()
        )
                .from(users)
                .where(users.userJoinDate.eq(nowDate).and(
                        users.userState.eq(1)
                ))
                .fetchOne();

        //당일 탈퇴 회원 수
        Long deleteCountByDay = jpaQueryFactory.select(
                users.count()
        )
                .from(users)
                .where(users.userDeleteDate.eq(nowDate).and(
                        users.userState.eq(0)
                ))
                .fetchOne();

        //총 탈퇴회원 수
        Long deleteTotalCount = jpaQueryFactory.select(
                users.count()
        )
                .from(users)
                .where(
                        users.userState.eq(0)
                )
                .fetchOne();

        List<Long> count = new ArrayList<>();
        count.add(totalCount);
        count.add(joinCount);
        count.add(deleteCountByDay);
        count.add(deleteTotalCount);

        Map<String, List> userStats = new HashMap<>();
        userStats.put("userInfoCount", count);
        userStats.put("userRecent", recentJoinDtoList);

        return userStats;
    }








    //회원상태
    private BooleanExpression userStateEq(String userState){

        return StringUtils.hasText(userState) ? users.userState.eq(Integer.valueOf(userState)) : null;
    }


    //회원리스트 - 셀렉트 옵션 동적 메소드
    private BooleanExpression cateEq(String cate, String keyword) {
        if (StringUtils.hasText(cate) && StringUtils.hasText(keyword)) {
            switch (cate) {
                case "userAccount":
                    return users.userAccount.containsIgnoreCase(keyword);
                case "userName":
                    return users.userName.containsIgnoreCase(keyword);
                case "userEmail":
                    return users.userEmail.containsIgnoreCase(keyword);
                case "userPhone":
                    return users.userPhone.containsIgnoreCase(keyword);

                default:
                    break;
            }
        }

        return users.id.isNotNull();
    }


}
