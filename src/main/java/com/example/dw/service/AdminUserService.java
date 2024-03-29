package com.example.dw.service;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.repository.user.UsersRepository;
import com.example.dw.repository.user.UsersRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AdminUserService {


    private final UsersRepository usersRepository;
    private final UsersRepositoryCustom usersRepositoryCustom;

    //회원 상세보기
    @Transactional
    public AdminUserDetailResultDto userDetail(Long userId){


        return usersRepositoryCustom.findByUserId(userId);
    }


    //회원 상세보기-qna 내역
    @Transactional
    public Page<AdminUserDetailQnaListDto> qnalist(Pageable pageable, Long userId){
        return usersRepositoryCustom.userDetailQnaList(pageable,userId);
    }

    //회원 상세보기 -자유게시판 내역
    @Transactional
    public Page<AdminUserDetailFreeBoardListDto> freeBoardList(Pageable pageable, Long userId){
        return usersRepositoryCustom.userDetailFreeBoardList(pageable, userId);
    }

    //회원 상세보기-산책 내역
    @Transactional
    public Page<AdminUserDetailWalkMateDto> walkMateList(Pageable pageable, Long userId){
        return usersRepositoryCustom.userDetailWalkMateList(pageable, userId);
    }


    //회원 상세보기-주문 내역
    @Transactional
    public Page<AdminUserDetailOrderResultWithTotalPriceDto> orderList(Pageable pageable, Long userId){
        return usersRepositoryCustom.userPaymentList(pageable,userId);
    }


    //회원 상태 수정
    @Transactional
    public void modifyUserStatus(Long userId){
        Users users = usersRepository.findById(userId).get();
        users.recoverUsersState();

    }


}
