package com.example.dw.service;


import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchCateLocationForm;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.admin.AdminCommunityRepositoryCustom;
import com.example.dw.repository.community.QuestionRepository;
import com.example.dw.repository.community.WalkingMateRepositoryCustom;
import com.example.dw.repository.freeBoard.FreeBoardRepository;
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
    private final QuestionRepository questionRepository;
    private final FreeBoardRepository freeBoardRepository;
    private final AdminCommunityRepositoryCustom adminCommunityRepositoryCustom;




    //qna 리스트
    @Transactional
    public Page<AdminQnaBoardList> qnaBoardList(Pageable pageable, SearchForm searchForm){

        return adminCommunityRepositoryCustom.qnaBoardList(pageable, searchForm);
    }

    //qna상세
    @Transactional
    public AdminQnaDetailResultDto qnaBoardDetail(Long qnaId){
        return adminCommunityRepositoryCustom.qnaDetail(qnaId);
    }

    //qna삭제
    @Transactional
    public void qnaDelete(Long qnaId){

        questionRepository.deleteById(qnaId);
    }

    //자유게시판 리스트
    @Transactional
    public Page<AdminFreeBoardList> freeBoardList(Pageable pageable, SearchForm searchForm){

        return adminCommunityRepositoryCustom.freeBoardList(pageable, searchForm);

    }
    
    //자유게시판 상세
    @Transactional
    public AdminFreeDetailResultDto freeBoardDetail(Long freeBoardId){
        return adminCommunityRepositoryCustom.freeBoardDetail(freeBoardId);
    }

    //자유게시판 삭제
    @Transactional
    public void freeBoardDelete(Long freeBoardId){

        freeBoardRepository.deleteById(freeBoardId);
    }



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
