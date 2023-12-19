package com.example.dw.service;

import com.example.dw.domain.entity.walkingMate.WalkingMate;
import com.example.dw.domain.form.WalkMateForm;
import com.example.dw.repository.community.WalkingMateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WalkingMateService {


    private final WalkingMateRepository walkingMateRepository;



    @Transactional
    public Long registerWalkingMate(WalkMateForm walkMateForm){

       WalkingMate walkingMate = walkingMateRepository.save(walkMateForm.toEntity());
       return walkingMate.getId();
    }



}
