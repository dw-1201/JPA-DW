package com.example.dw.repository.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImp implements OrderRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

}
