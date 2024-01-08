package com.example.dw.service;


import com.example.dw.domain.dto.admin.AdminWalkMateDetailDto;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchCateLocationForm;
import com.example.dw.repository.community.WalkingMateRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminCommunityService {


    private final WalkingMateRepositoryCustom walkingMateRepositoryCustom;


    //관리자 산책모집글 리스트
    @Transactional
    public Page<WalkMateListDto> walkMateList(int page, SearchCateLocationForm searchCateLocationForm){

        Pageable pageable = PageRequest.of(page, 15);
        return walkingMateRepositoryCustom.findAllWalkMate(pageable, searchCateLocationForm);
    }

    //관리자 산책모집글 상세보기
    @Transactional
    public AdminWalkMateDetailDto walkMateDetailPage(Long walkMateId){

        return Optional.ofNullable(walkingMateRepositoryCustom.adminWalkMateDetail(walkMateId))
                .orElseThrow(()->{throw new IllegalArgumentException("조회정보 없음");});
    }

}
