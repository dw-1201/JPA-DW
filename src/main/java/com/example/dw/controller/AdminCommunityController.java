package com.example.dw.controller;

import com.example.dw.aspect.annotation.LoggingPointCut;
import com.example.dw.domain.dto.admin.AdminFreeDetailResultDto;
import com.example.dw.domain.dto.admin.AdminQnaDetailResultDto;
import com.example.dw.domain.dto.admin.AdminWalkMateDetailDto;
import com.example.dw.service.AdminCommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminCommunityController {


    private final AdminCommunityService adminCommunityService;

    @GetMapping("/qnaList")
    public String qnaList(){
        return "/admin/adminQnaList";
    }

    //qna상세
    @GetMapping("/questionDetail/{qnaId}")
    public String qnaDetail(@PathVariable("qnaId") Long qnaId,
                            Model model){


        AdminQnaDetailResultDto detail = adminCommunityService.qnaBoardDetail(qnaId);
        model.addAttribute("qnaDetail", detail);
        System.out.println("[ Qna상세정보 ] : " + detail.toString());

        return "/admin/adminQnaDetail";
    }

    //qna 삭제
    @GetMapping("/questionDelete/{qnaId}")
    public RedirectView qnaDelete(@PathVariable("qnaId") Long qnaId){

        adminCommunityService.qnaDelete(qnaId);

        return new RedirectView("/admin/qnaList");

    }

    @GetMapping("/freeBoardList")
    public String freeBoardList(){
        return "/admin/adminFreeList";
    }


    //자유게시판 상세
    @GetMapping("/freeBoardDetail/{freeBoardId}")
    public String freeBoardDetail(@PathVariable("freeBoardId") Long freeBoardId,
                                  Model model){

        AdminFreeDetailResultDto detail = adminCommunityService.freeBoardDetail(freeBoardId);
        model.addAttribute("detail" , detail);
        return "/admin/adminFreeDetail";
    }

    //자유게시판 삭제
    @GetMapping("/freeBoardDelete/{freeBoardId}")
    public RedirectView freeBoardDelete(@PathVariable("freeBoardId") Long freeBoardId){

        adminCommunityService.freeBoardDelete(freeBoardId);

        return new RedirectView("/admin/freeBoardList");
    }

    @GetMapping("/walkBoardList")
    public String walkBoardList(){
        return "/admin/adminWalkList";
    }





    //산책글 상세보기
    @LoggingPointCut
    @GetMapping("/walkMateDetail/{walkMateId}")
    public String walkMateDetailPage(
            @PathVariable("walkMateId") Long walkMateId,
            Model model){

       AdminWalkMateDetailDto adminWalkMateDetailDto = adminCommunityService.walkMateDetailPage(walkMateId);

       model.addAttribute("detail", adminWalkMateDetailDto);
        return "/admin/adminWalkDetail";
    }

}
