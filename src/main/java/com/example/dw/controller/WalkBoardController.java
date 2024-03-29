package com.example.dw.controller;


import com.example.dw.domain.dto.community.WalkDetailStateDto;
import com.example.dw.domain.dto.community.WalkMateDetailDto;
import com.example.dw.domain.dto.user.UserPetDto;
import com.example.dw.domain.form.WalkMateForm;
import com.example.dw.service.WalkingMateService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/walk")
public class WalkBoardController {


    private final WalkingMateService walkingMateService;

    //산책글 리스트 페이지 이동
    @GetMapping("/walkList")
    public String walkList(){
        return "/community/walkingMateList";
    }



    //산책글 작성 페이지 이동
    @GetMapping("/walkWrite")
    public String walkWrite(Model model, HttpSession session){

        List<UserPetDto> userPets = walkingMateService.getUserPets((Long)session.getAttribute("userId"));
        System.out.println(userPets.toString());
        model.addAttribute("pets", userPets);

        return "/community/walkingMateWrite";


    }


    //산책글작성 완료
    @PostMapping("/registerWalkMate")
    public RedirectView registerWalk(WalkMateForm walkMateForm, HttpSession session){


        Long userId = (Long)session.getAttribute("userId");
        walkMateForm.setUserId(userId);
        System.out.println(walkMateForm.toString());



        walkingMateService.registerWalkingMate(walkMateForm);

        return new RedirectView("/walk/walkList");
    }




    //산책글 상세보기
    @GetMapping("/detail/{id}/{userId}")
    public String walkDetail(@PathVariable("id") Long id, Model model, HttpSession session){
        
        Optional<WalkMateDetailDto> detail =  walkingMateService.walkDetailPage(id);

        System.out.println("[ 산책글 상세 ] : " + detail.toString());

        detail.ifPresent( details -> model.addAttribute("detail", details));

        List<WalkDetailStateDto> applierPetInfo = walkingMateService.findApplierPetInfo(id);
        System.out.println("[ 산책글 승인받은 신청자 펫정보 ] : " + applierPetInfo);
        model.addAttribute("applierPetInfo", applierPetInfo);
        
        //신청자 pet 목록
        
        try{
            //로그인 상태일 시
            Long sessionUserId = (Long)session.getAttribute("userId");

            if(sessionUserId != null){
                //신청자 펫리스트
                List<UserPetDto> petList = walkingMateService.getUserPets(sessionUserId);
                model.addAttribute("sessionUserPet", petList);

                //신청상태 확인
                Long applyUserId = walkingMateService.applyState(sessionUserId, detail.get().getId());
                model.addAttribute("replyAuthorized", applyUserId);
            }

        }catch (Exception e){
            
            //비로그인 상태면 예외처리
            e.printStackTrace();
        }


        return "/community/walkingMateDetail";
    }

    //산책글 수정페이지 이동
    @GetMapping("/modify/{id}")
    public String walkModify(@PathVariable("id") Long id,
                        Model model, HttpSession session){

        Long userId = (Long)session.getAttribute("userId");
        List<UserPetDto> userPets = walkingMateService.getUserPets(userId);
        System.out.println(userPets.toString());
        model.addAttribute("pets", userPets);



        Optional<WalkMateDetailDto> detail =  walkingMateService.walkDetailPage(id);
        detail.ifPresent( details -> model.addAttribute("detail", details));
        System.out.println(detail.toString());

        return "/community/walkingMateModify";

    }


    //산책글 수정 완료
    @PostMapping("/modifyOk/{id}")
    public RedirectView walkModifyOk(WalkMateForm walkMateForm){

        System.out.println("[ 산책글 수정 사항 ] : "+walkMateForm.toString());
        walkingMateService.walkModify(walkMateForm);

        return new RedirectView("/walk/walkList");

    }

    //산책글 삭제
    @GetMapping("/deleteWalkMate/{walkBoardId}")
    public RedirectView deleteWalkMate(@PathVariable("walkBoardId") Long walkBoardId){

        walkingMateService.walkDelete(walkBoardId);

        return new RedirectView("/walk/walkList");
    }


    //산책메이트 신청 철회
    @GetMapping("/applyCancel/{walkMateId}/{userId}")
    public RedirectView applyCancel(
            @PathVariable("walkMateId") Long walkMateId,
            @PathVariable("userId") Long userId
    ){
        walkingMateService.applyCanCel(walkMateId, userId);

        return new RedirectView("/walk/detail/"+walkMateId +"/"+userId);

    }


}
