package com.example.dw.repository.user;

import com.example.dw.domain.dto.admin.UserChartDto;
import com.example.dw.domain.dto.user.UserDetailDto;
import com.example.dw.domain.dto.user.UserListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UsersRepositoryCustom {

    Page<UserListDto> findByAll(Pageable pageable, String cate, String keyword, String userState);

    Optional<UserDetailDto> findByUserId(Long userId);

    List<UserChartDto> findJoinCountByAll();


    Map<String, List> newUserStatus();




}
