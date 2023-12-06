package com.example.dw.controller;

import com.example.dw.domain.entity.admin.FaqBoard;
import com.example.dw.domain.form.FaqBoardForm;
import com.example.dw.domain.form.NoticeBoardForm;
import com.example.dw.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    //공지리스트
    @GetMapping("/noticeList")
        public String noticeList(){
            return "/admin/adminNoticeList";

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

    //Faq작성 페이지 이동
    @GetMapping("/faqWrite")
    public String faqWritePage(){
        return "/admin/adminFaqReg";
    }

    //Faq 작성
    @PostMapping("/faqWrite")
    public RedirectView faqWrite(FaqBoardForm faqBoardForm){

        System.out.println(faqBoardForm.getId());



        adminService.faqRegister(faqBoardForm);

        return new RedirectView("/admin/noticeList");
    }

    //faq 수정 페이지 이동
    @GetMapping("/faqModifyPage/{faqBoardId}")
    public String faqModifyPage(@PathVariable("faqBoardId") Long faqBoardId, Model model){

        FaqBoard faqBoard = adminService.faqDetail(faqBoardId);

        FaqBoardForm faqBoardForm = new FaqBoardForm();
        faqBoardForm.setId(faqBoardId);
        faqBoardForm.setFaqBoardTitle(faqBoard.getFaqBoardTitle());
        faqBoardForm.setFaqBoardContent(faqBoard.getFaqBoardContent());

        model.addAttribute("detail", faqBoardForm);

        return "/admin/adminFaqModify";
    }

    //faq 수정 완료
    @PutMapping("/faqModify/{id}/edit")
    public RedirectView faqModify(
            @PathVariable("id") Long faqBoardId,
            FaqBoardForm faqBoardForm){
        System.out.println(faqBoardId+"===========================");

        adminService.faqModify(faqBoardForm, faqBoardId);


        return new RedirectView("/admin/noticeList");
    }

    //faq 삭제
    @GetMapping("/faqDelete/{id}")
        public RedirectView faqDelete(
                @PathVariable("id") Long faqBoardId){

        adminService.faqDelete(faqBoardId);

        return new RedirectView("/admin/noticeList");

    }

}
