package com.example.dw.controller;

import com.example.dw.entity.dto.NoticeBoardForm;
import com.example.dw.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {

    private final AdminService adminService;


    @GetMapping("/FBList")
    public String FreeBoardList(){
        return "/admin/adminFreeList";
    }

    @GetMapping("/goodsList")
    public String GoodsList(){
        return "/admin/adminGoodsList";
    }

    @GetMapping("/goodsReg")
    public String goodsRegister(){
        return "/admin/adminGoodsReg";
    }


    //공지사항 작성 페이지 이동
    @GetMapping("/noticeWrite")
    public String noticeWritePage(){
        return "/admin/adminNoticeReg";
    }

    //공지사항 작성
    @PostMapping("/noticeWrite")
    public String noticeWrite(NoticeBoardForm noticeBoardForm){

        adminService.register(noticeBoardForm);

        return "/admin/adminNoticeList";

    }



}
