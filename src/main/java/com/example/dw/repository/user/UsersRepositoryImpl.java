package com.example.dw.repository.user;

import com.example.dw.domain.dto.user.QUserListDto;
import com.example.dw.domain.dto.user.UserListDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.dw.domain.entity.user.QUsers.users;

@Repository
@RequiredArgsConstructor
public class UsersRepositoryImpl implements UsersRepositoryCustom {


    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<UserListDto> findByAll(Pageable pageable) {

        List<UserListDto> content = getUserList(pageable);
        Long counts = getCount();

        return new PageImpl<>(content, pageable, counts);
    }


    private Long getCount(){
        return jpaQueryFactory.select(users.count())
                .from(users)
                .fetchOne();
    }


    private List<UserListDto> getUserList(Pageable pageable){
        return jpaQueryFactory.select(new QUserListDto(
                users.id,
                users.userAccount,
                users.userName,
                users.userEmail,
                users.userPhone
        ))
                .from(users)
                .orderBy(users.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

    }



}
