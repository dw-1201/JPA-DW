package com.example.dw.service;

import com.example.dw.domain.dto.community.WalkMateDetailDto;
import com.example.dw.domain.dto.community.WalkMateDetailReplyDto;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.dto.user.UserPetDto;
import com.example.dw.domain.entity.walkingMate.WalkingMate;
import com.example.dw.domain.form.*;
import com.example.dw.repository.community.*;
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
    private final WalkingMateStateRepository walkingMateStateRepository;

    //산책모집글 리스트
    @Transactional
    public Page<WalkMateListDto> walkMateList(int page , SearchLocationForm searchLocationForm){


        Pageable pageable = PageRequest.of(page, 15);
        return walkingMateRepositoryCustom.findAllWalkMate(pageable, searchLocationForm);
    }



    //산책 모집글 작성
    @Transactional
    public Long registerWalkingMate(WalkMateForm walkMateForm){

        //산책글 작성
       WalkingMate walkingMate = walkingMateRepository.save(walkMateForm.toEntity());

       //작성 성공 시 walkingMateState 생성하고 작성자 정보 입력
       registerWalkingMateState(walkingMate.getId(), walkingMate.getUsers().getId(), walkingMate.getPet().getId());



        return walkingMate.getId();
    }


    //산책 모집글 작성시 walkingMateState 동시 생성
    @Transactional
    public Long registerWalkingMateState(Long walkingMateId, Long userId, Long petId){

        WalkingMateStateForm walkingMateStateForm = new WalkingMateStateForm();
        walkingMateStateForm.setPetId(petId);
        walkingMateStateForm.setWalkingMateId(walkingMateId);
        walkingMateStateForm.setUserId(userId);
        walkingMateStateForm.setState(1);


        Long id = walkingMateStateRepository.save(walkingMateStateForm.toEntity()).getId();

        return id;
    }


    //산책글 신청
    @Transactional
    public void applyWalkMate(WalkingMateStateForm walkingMateStateForm){

        walkingMateStateRepository.save(walkingMateStateForm.toEntity());

    }

    //산책글 신청 중복검사
    @Transactional
    public Long applyCheck(Long walkMateId, Long userId){

        Long id = walkingMateStateRepository.applyCheck(walkMateId, userId);


        if(id==null){
            return 0L;
        }else {
            return id;
        }

    }

    //산책글 신청 취소
    @Transactional
    public void applyCanCel(Long walkMateId, Long userId){

        Long id = walkingMateStateRepository.applyCheck(walkMateId, userId);

        walkingMateStateRepository.deleteById(id);

    }



    //등록 펫 정보
    @Transactional
    public List<UserPetDto> getUserPets(Long userId){

       return usersRepositoryCustom.findAllPetByUserId(userId);
    }

    //산책글 상세보기
    @Transactional
    public Optional<WalkMateDetailDto> walkDetailPage(Long walkBoardId){


        //조회수 증가
        walkingMateRepository.updateViewCount(walkBoardId);

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

        return walkingMateCommentCustom.findReplyByWalkBoardId(walkBoardId);

    }

    //산책글 댓글 수정
    @Transactional
    public void modifyReply(WalkingMateCommentForm walkingMateCommentForm){

        walkingMateCommentRepository.updateComment(walkingMateCommentForm.getWalkBoardComment(), walkingMateCommentForm.getId());

    }

    //산책글 댓글 삭제
    @Transactional
    public void deleteReply(Long walkCommentId){

        walkingMateCommentRepository.deleteById(walkCommentId);
    }
}
