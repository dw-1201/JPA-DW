package com.example.dw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminCommunityController {



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

}
