package com.example.dw.controller;

import com.example.dw.domain.dto.community.FreeBoardDetailDto;
import com.example.dw.domain.form.FreeBoardModifyForm;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FreeBoardCommentService;
import com.example.dw.service.FreeBoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/community/*")
public class FreeBoardController {

    private FreeBoardService freeBoardService;
    private FreeBoardRepositoryCustom freeBoardRepositoryCustom;
    private FreeBoardCommentService freeBoardCommentService;  // 새로 추가
    private final HttpSession httpSession;

    @Autowired
    public FreeBoardController(FreeBoardService freeBoardService, HttpSession httpSession, FreeBoardRepositoryCustom freeBoardRepositoryCustom, FreeBoardCommentService freeBoardCommentService) {
        this.freeBoardService = freeBoardService;
        this.httpSession = httpSession;
        this.freeBoardRepositoryCustom = freeBoardRepositoryCustom;
        this.freeBoardCommentService = freeBoardCommentService;  // 새로 추가
    }

    /**
     * 자유게시판 리스트 페이지
     * @return
     */
    @GetMapping("/freeBoardList")
    public String freeBoard(){

        return "/community/freeBoardList";
    }


    /**
     * 자유게시판 글쓰기 페이지
     * @return
     */
    @GetMapping("/freeBoardWriting")
    public String freeBoardWriting(){
        return "/community/freeBoardWriting";
    }

    @PostMapping("/freeBoardWriting")
    public String write(FreeBoardWritingForm freeBoardWritingForm){
        // 세션에서 사용자 ID 가져오기
        Long userId = (Long) httpSession.getAttribute("userId");

        // 해당 사용자 ID로 글 작성
        freeBoardWritingForm.setUserId(userId);
        freeBoardService.saveFreeBoard(freeBoardWritingForm);
        return "redirect:/community/freeBoardList";
    }

    /**
     * 자유게시판 상세 페이지
     * @return
     */
    @GetMapping("/freeBoardDetail/{freeBoardId}")
    public String freeBoardDetail(@PathVariable("freeBoardId") Long freeBoardId, Model model){
        List<FreeBoardDetailDto> result =
                freeBoardRepositoryCustom.findFreeBoardById(freeBoardId);

        // 조회수 증가
        freeBoardService.increaseViewCount(freeBoardId);

        System.out.println("[자유게시판 상세 페이지] : "+result.toString());

        model.addAttribute("detail",result);

        return "/community/freeBoardDetail";
    }

    /**
     * 자유게시판 수정 페이지
     * @return
     */
    @GetMapping("/modify/{freeBoardId}")
    public String freeBoardModifyPage(@PathVariable("freeBoardId") Long freeBoardId, Model model){

        List<FreeBoardDetailDto> result =
                freeBoardRepositoryCustom.findFreeBoardById(freeBoardId);

        model.addAttribute("detail", result);

        return "/community/freeBoardModify";
    }

    /**
     * 자유게시판 수정
     * @return
     */
    @PutMapping("/modify/{freeBoardId}/edit")
    public RedirectView freeBoardModify(@PathVariable("freeBoardId") Long freeBoardId,
                                    FreeBoardModifyForm freeBoardModifyForm)
            throws IOException {

        freeBoardModifyForm.setId(freeBoardId);
        System.out.println("받아오는 자유게시판 번호 : "+freeBoardModifyForm.getId());

//        freeBoardService.modify(freeBoardModifyForm);

        return new RedirectView("/community/freeBoardDetail/{freeBoardId}");
    }

    /**
     * 자유게시판 삭제
     * @return
     */
    @GetMapping("/delete/{freeBoardId}")
    public RedirectView goodsDelete(@PathVariable("freeBoardId") Long freeBoardId){


        freeBoardService.delete(freeBoardId);

        return new RedirectView("/community/freeBoardList");
    }
}
