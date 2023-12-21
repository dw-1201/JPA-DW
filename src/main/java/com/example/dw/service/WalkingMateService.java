package com.example.dw.service;

import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.entity.walkingMate.WalkingMate;
import com.example.dw.domain.form.SearchLocationForm;
import com.example.dw.domain.form.WalkMateForm;
import com.example.dw.repository.community.WalkingMateRepository;
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
public class WalkingMateService {


    private final WalkingMateRepository walkingMateRepository;
    private final WalkingMateRepositoryCustom walkingMateRepositoryCustom;


    //산책모집글 리스트
    @Transactional
    public Page<WalkMateListDto> walkMateList(int page , SearchLocationForm searchLocationForm){


        Pageable pageable = PageRequest.of(page, 10);
        return walkingMateRepositoryCustom.findAllWalkMate(pageable, searchLocationForm);
    }
    
    //산책 모집글 작성
    @Transactional
    public Long registerWalkingMate(WalkMateForm walkMateForm){

       WalkingMate walkingMate = walkingMateRepository.save(walkMateForm.toEntity());
       return walkingMate.getId();
    }

   



}