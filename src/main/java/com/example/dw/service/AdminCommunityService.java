package com.example.dw.service;


import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.community.WalkingMateRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminCommunityService {


    private final WalkingMateRepositoryCustom walkingMateRepositoryCustom;


    //관리자 산책모집글 리스트
    @Transactional
    public Page<WalkMateListDto> walkMateList(int page , SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 15);
        return walkingMateRepositoryCustom.findAllWalkMate(pageable, searchForm);
    }


}
