package com.example.dw.api;


import com.example.dw.domain.dto.community.WalkMateDetailReplyDto;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchLocationForm;
import com.example.dw.domain.form.WalkingMateCommentForm;
import com.example.dw.domain.form.WalkingMateStateForm;
import com.example.dw.service.WalkingMateService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/walks/*")
@RequiredArgsConstructor
public class WalkBoardApiController {


    private final WalkingMateService walkingMateService;


    @Value("${file.user}")
    private String userImg;

    //세션값 확인
    @PostMapping("/sessionOk")
    public Long checkSession(HttpSession session){

        return (Long)session.getAttribute("userId");
    }

    //산책메이트 모집글 리스트
    @GetMapping("/walkList/{page}")
    public Page<WalkMateListDto> getWalkList(@PathVariable("page") int page,
                                             SearchLocationForm searchLocationForm){

        System.out.println(searchLocationForm.toString());
        return walkingMateService.walkMateList(page, searchLocationForm);
    }

    //산책글 작성확인(동일요일 1회)
    @PostMapping("/limitCheck/{userId}")
    public Integer limitCheck(@PathVariable("userId") Long userId,
                           String walkingMateDate){

        System.out.println(walkingMateDate+"!@#@!#!@#!@");
        return walkingMateService.limitWriteByDay(userId, walkingMateDate);

    }




    //산책메이트 상세보기 댓글 등록
    @PostMapping("/detailReply")
    public void registerReply(WalkingMateCommentForm walkingMateCommentForm){

        walkingMateService.walkDetailReply(walkingMateCommentForm);

    }

    //산책메이트 상세보기 댓글 목록
    @GetMapping("/showReplyList/{walkBoardId}")
    public List<WalkMateDetailReplyDto> showReplyList(
            @PathVariable("walkBoardId") Long walkBoardId
    ){

        return walkingMateService.getReplyList(walkBoardId);

    }

    //산책메이트 상세보기 댓글 유저 사진
    @GetMapping("/walkDetailImg")
    public byte[] getEmpImg(String userImgPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(userImg, userImgPath));
    }


    //산책메이트 상세보기 댓글 수정
    @PatchMapping("/walkReplyModify")
    public void modifyReply(WalkingMateCommentForm walkingMateCommentForm){

        System.out.println(walkingMateCommentForm.toString());

        walkingMateService.modifyReply(walkingMateCommentForm);

    }


    //산책메이트 상세보기 댓글 삭제
    @DeleteMapping("/walkReplyDelete/{walkCommentId}")
    public void deleteReply(@PathVariable("walkCommentId") Long walkCommentId){

        walkingMateService.deleteReply(walkCommentId);
    }



// 산책메이트 신청 중복검사
    @GetMapping("/applyCheck/{walkMateId}")
    public Long applyCheck(@PathVariable("walkMateId") Long walkMateId, HttpSession session){

            Long sessionUserId = (Long)session.getAttribute("userId");

            return walkingMateService.applyCheck(walkMateId, sessionUserId);
    }


//    산책메이트 신청
    @GetMapping("/applyWalkMate")
    public void applyWalkMate(WalkingMateStateForm walkingMateStateForm){


        walkingMateService.applyWalkMate(walkingMateStateForm);

    }

//    //신청자 펫 정보 //post맨 확인용
//    @GetMapping("/applierPetInfo/{walkMateId}")
//    public List<WalkDetailStateDto> applierPetInfo(
//            @PathVariable("walkMateId") Long walkMateId){
//
//        return walkingMateService.findApplierPetInfo(walkMateId);
//
//    }


}
