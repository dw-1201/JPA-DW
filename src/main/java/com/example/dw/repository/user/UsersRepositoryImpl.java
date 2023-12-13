package com.example.dw.repository.user;

import com.example.dw.domain.dto.admin.UserChartDto;
import com.example.dw.domain.dto.user.QUserDetailDto;
import com.example.dw.domain.dto.user.QUserListDto;
import com.example.dw.domain.dto.user.UserDetailDto;
import com.example.dw.domain.dto.user.UserListDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.dw.domain.entity.freeBoard.QFreeBoard.freeBoard;
import static com.example.dw.domain.entity.question.QQuestion.question;
import static com.example.dw.domain.entity.user.QUsers.users;

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

        UserDetailDto detail = getUserDetail(userId);

        return Optional.ofNullable(detail);
    }

    @Override
    public List<UserChartDto> findJoinCountByAll() {
        return getDailyJoinCount();
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
                users.userIntroduction
        ))
                .from(users)
                .where(users.id.eq(userId))
                .fetchOne();
    }

    public List<UserChartDto> getDailyJoinCount() {
        LocalDate endDate = LocalDate.now(); // 현재 날짜
        LocalDate startDate = endDate.minusWeeks(1); // 일주일 전 날짜

        // 일주일 간의 날짜 목록 생성
        List<LocalDate> datesInRange = startDate.datesUntil(endDate.plusDays(1))
                .collect(Collectors.toList());

        Map<LocalDate, Long> dailyCounts = jpaQueryFactory
                .select(users.userJoinDate, users.count())
                .from(users)
                .where(users.userJoinDate.between(startDate, endDate))
                .groupBy(users.userJoinDate)
                .fetch()
                .stream()
                .collect(Collectors.toMap(
                        tuple -> tuple.get(users.userJoinDate),
                        tuple -> tuple.get(users.count()),
                        (count1, count2) -> count1 + count2
                ));

        // 빈 값을 가진 날짜에 대한 결과 추가
        for (LocalDate date : datesInRange) {
            dailyCounts.putIfAbsent(date, 0L);
        }

        return dailyCounts.entrySet().stream()
                .map(entry -> new UserChartDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
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
