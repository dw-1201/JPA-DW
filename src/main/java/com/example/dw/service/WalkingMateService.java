package com.example.dw.service;

import com.example.dw.domain.dto.community.WalkMateDetailDto;
import com.example.dw.domain.dto.community.WalkMateDetailReplyDto;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.dto.user.UserPetDto;
import com.example.dw.domain.entity.walkingMate.WalkingMate;
import com.example.dw.domain.entity.walkingMate.WalkingMateComment;
import com.example.dw.domain.form.SearchLocationForm;
import com.example.dw.domain.form.WalkMateForm;
import com.example.dw.domain.form.WalkingMateCommentForm;
import com.example.dw.repository.community.WalkingMateCommentCustom;
import com.example.dw.repository.community.WalkingMateCommentRepository;
import com.example.dw.repository.community.WalkingMateRepository;
import com.example.dw.repository.community.WalkingMateRepositoryCustom;
import com.example.dw.repository.user.UsersRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WalkingMateService {


    private final WalkingMateRepository walkingMateRepository;
    private final WalkingMateRepositoryCustom walkingMateRepositoryCustom;
    private final WalkingMateCommentRepository walkingMateCommentRepository;
    private final WalkingMateCommentCustom walkingMateCommentCustom;
    private final UsersRepositoryCustom usersRepositoryCustom;

    //산책모집글 리스트
    @Transactional
    public Page<WalkMateListDto> walkMateList(int page , SearchLocationForm searchLocationForm){


        Pageable pageable = PageRequest.of(page, 15);
        return walkingMateRepositoryCustom.findAllWalkMate(pageable, searchLocationForm);
    }



    //산책 모집글 작성
    @Transactional
    public Long registerWalkingMate(WalkMateForm walkMateForm){

       WalkingMate walkingMate = walkingMateRepository.save(walkMateForm.toEntity());
       return walkingMate.getId();
    }



    //등록 펫 정보
    @Transactional
    public List<UserPetDto> getUserPets(Long userId){

       return usersRepositoryCustom.findAllPetByUserId(userId);
    }

    //산책글 상세보기
    @Transactional
    public Optional<WalkMateDetailDto> walkDetailPage(Long walkBoardId){

        WalkingMate walkingMate = walkingMateRepository.findById(walkBoardId).get();
        walkingMate.updateViewCount();

        return walkingMateRepositoryCustom.walkMateDetail(walkBoardId);
    }


    //산책글 수정
    @Transactional
    public void walkModify(WalkMateForm walkMateForm){

        WalkingMate walkingMate = walkingMateRepository.findById(walkMateForm.getId()).get();

        walkingMate.update(walkMateForm);

    }

    //산책글 댓글 등록
    @Transactional
    public void walkDetailReply(WalkingMateCommentForm walkingMateCommentForm){

        walkingMateCommentRepository.save(walkingMateCommentForm. toEntity());
    }

    //산책글 댓글 목록
    @Transactional
    public List<WalkMateDetailReplyDto> getReplyList(Long walkBoardId){
        System.out.println((walkingMateCommentCustom.findReplyByWalkBoardId(walkBoardId)).toString());
        return walkingMateCommentCustom.findReplyByWalkBoardId(walkBoardId);

    }

    //댓글 수정
    @Transactional
    public void modifyReply(WalkingMateCommentForm walkingMateCommentForm){

        WalkingMateComment walkingMateComment = walkingMateCommentRepository.findById(walkingMateCommentForm.getId()).get();

        walkingMateComment.update(walkingMateCommentForm);

    }

    //댓글 삭제
    @Transactional
    public void deleteReply(Long walkdCommentId){
        walkingMateCommentRepository.deleteById(walkdCommentId);
    }
}
