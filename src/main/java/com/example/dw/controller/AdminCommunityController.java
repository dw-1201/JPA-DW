package com.example.dw.controller;

import com.example.dw.aspect.annotation.LoggingPointCut;
import com.example.dw.domain.dto.admin.AdminWalkMateDetailDto;
import com.example.dw.service.AdminCommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminCommunityController {


    private final AdminCommunityService adminCommunityService;

    @GetMapping("/qnaList")
    public String qnaList(){
        return "/admin/adminQnaList";
    }

    @GetMapping("/freeBoardList")
    public String freeBoardList(){
        return "/admin/adminFreeList";
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
