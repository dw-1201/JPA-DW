package com.example.dw.repository.user;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.dto.user.UserPetDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersRepositoryCustom {

    //관리자 페이지회원리스트
    Page<UserListDto> findByAll(Pageable pageable, String cate, String keyword, String userState);

    //관리자페이지 회원상세
    AdminUserDetailResultDto findByUserId(Long userId);
    
    //관리자페이지 회원상세 회원 구매내역
    Page<AdminUserDetailOrderResultDto> userPaymentList(Pageable pageable,Long userId);
    

    //관리자페이지 일별 회원가입수
    List<AdminUserChartDto> findJoinCountByAll();

    


    Map<String, List> newUserStatus();

//    Optional<UserFileDto> findDtoByUserId(Long userId);

    Optional<UserDetailListDto> findOneByUserId(Long userId);

    List<UserFileDto> findAllByUserId(Long userId);

    //등록된 펫 이름 가져오기
    List<UserPetDto> findAllPetByUserId(Long userId);

}
