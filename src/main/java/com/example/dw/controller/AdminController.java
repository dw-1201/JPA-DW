package com.example.dw.controller;

import com.example.dw.domain.dto.user.UserDetailDto;
import com.example.dw.domain.entity.admin.FaqBoard;
import com.example.dw.domain.entity.admin.NoticeBoard;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.FaqBoardForm;
import com.example.dw.domain.form.NoticeBoardForm;
import com.example.dw.repository.user.UsersRepository;
import com.example.dw.repository.user.UsersRepositoryCustom;
import com.example.dw.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminController {

    private final AdminService adminService;
    private final UsersRepositoryCustom usersRepositoryCustom;
    private final UsersRepository usersRepository;

    
    //관리자 로그인 페이지
    //관리자 로그인
    //관리자 로그아웃
    
    
    
    @GetMapping("/FBList")
    public String FreeBoardList(){
        return "/admin/adminFreeList";
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
    //추후 삭제는 비동기로 바꿀까 생각중
    //faq 삭제
    @GetMapping("/faqDelete/{id}")
        public RedirectView faqDelete(
                @PathVariable("id") Long faqBoardId){

        adminService.faqDelete(faqBoardId);

        return new RedirectView("/admin/noticeList");

    }

    //공지사항 수정 페이지
    @GetMapping("/noticeModifyPage/{noticeBoardId}")
    public String noticeModifyPage(@PathVariable("noticeBoardId")Long noticeBoardId,
                                  Model model){

        NoticeBoard noticeBoard = adminService.noticeDetail(noticeBoardId);
        NoticeBoardForm noticeBoardForm = new NoticeBoardForm();
        noticeBoardForm.setId(noticeBoardId);
        noticeBoardForm.setNoticeBoardTitle(noticeBoard.getNoticeBoardTitle());
        noticeBoardForm.setNoticeBoardContent(noticeBoard.getNoticeBoardContent());

        model.addAttribute("detail", noticeBoardForm);
        return "/admin/adminNoticeModify";
    }
    
    //공지사항 수정 완료
    @PutMapping("/noticeModify/{id}/edit")
    public RedirectView noticeModify(@PathVariable("id") Long id,
                                     NoticeBoardForm noticeBoardForm){

        adminService.noticeModify(noticeBoardForm,id);

        return new RedirectView("/admin/noticeList");

    }


    //추후 삭제는 비동기로 바꿀까 생각중
    //공지사항 삭제
    @GetMapping("/noticeDelete/{id}")
    public RedirectView noticeDelete(@PathVariable("id") Long id){

        adminService.noticeDelete(id);

        return new RedirectView("/admin/noticeList");

    }

    //////////////////////

    //회원현황
    @GetMapping("/userStatus")
    public String userStatus(){
        return "/admin/adminIndex";
    }

    //회원 리스트
    @GetMapping("/userList")
    public String userList(){
        
     return "/admin/adminUserList";
    }

    //회원 상세 보기
    @GetMapping("/userDetail/{userId}")
    public String userDetail(@PathVariable("userId") Long userId, Model model){

        Optional<UserDetailDto> userDetail = usersRepositoryCustom.findByUserId(userId);

        //옵셔널 객체로 감싸진 경우 타임리프로 받을 수 없다.
        //따라서 ifPresent로 추출하여 모델 객체에 담아줘야함
        userDetail.ifPresent(  detail -> model.addAttribute("detail", detail));

        return "/admin/adminUserDetail";
    }

    //회원 탈퇴
    @GetMapping("/userDelete/{userId}")
    public RedirectView userDelete(@PathVariable("userId") Long userId){

        usersRepository.deleteById(userId);

        return new RedirectView("/admin/userList");

    }

    //회원 복구
    @GetMapping("/userRecover/{userId}")
    public RedirectView userRecover(@PathVariable("userId") Long userId){

        Users users = usersRepository.findById(userId).get();

        users.recoverUsersState();

        usersRepository.save(users);

        return new RedirectView("/admin/userList");
    }




}
