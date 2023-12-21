package com.example.dw.repository.user;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.dto.community.QuestionListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersRepositoryCustom {

    Page<UserListDto> findByAll(Pageable pageable, String cate, String keyword, String userState);

    Optional<UserDetailDto> findByUserId(Long userId);

    List<AdminUserChartDto> findJoinCountByAll();


    Map<String, List> newUserStatus();

//    Optional<UserFileDto> findDtoByUserId(Long userId);

    Optional<UserDetailListDto> findOneByUserId(Long userId);

    List<UserFileDto> findAllByUserId(Long userId);



}
