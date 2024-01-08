package com.example.dw.repository.community;

import com.example.dw.domain.dto.admin.AdminWalkMateDetailDto;
import com.example.dw.domain.dto.community.WalkMateDetailDto;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.dto.community.WalkMateMyApplicationListDto;
import com.example.dw.domain.dto.community.WalkMateMyListDto;
import com.example.dw.domain.form.SearchCateLocationForm;
import com.example.dw.domain.form.SearchLocationForm;
import com.example.dw.domain.form.SearchRecruitmentForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface WalkingMateRepositoryCustom {

    Page<WalkMateListDto> findAllWalkMate(Pageable pageable, SearchLocationForm searchLocationForm);

    Page<WalkMateListDto> findAllWalkMate(Pageable pageable, SearchCateLocationForm searchCateLocationForm);

    Page<WalkMateMyListDto> findAllWalkMateAndUserId(Pageable pageable, SearchRecruitmentForm searchRecruitmentForm, Long userId);

    Page<WalkMateMyApplicationListDto> findAllWalkMateStateAndUserId(Pageable pageable, Long userId);

    Optional<WalkMateDetailDto> walkMateDetail(Long walkBoardId);

//    List<WalkDetailStateDto> applierPetsInfo(Long walkMateId);

    //관리자 페이지 산책글 상세
    AdminWalkMateDetailDto adminWalkMateDetail(Long walkMateId);



}
