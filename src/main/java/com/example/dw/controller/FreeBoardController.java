package com.example.dw.controller;

import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.service.FreeBoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/community/*")
public class FreeBoardController {

    private FreeBoardService freeBoardService;
    private final HttpSession httpSession;

    @Autowired
    public FreeBoardController(FreeBoardService freeBoardService, HttpSession httpSession) {
        this.freeBoardService = freeBoardService;
        this.httpSession = httpSession;
    }
    //Controller에서 ervice를 주입받고,
    //검색 결과를 "/community/freeBoardList/search" 뷰로 전달할 수 있게

    /**
     * 게시글 리스트 페이지
     * @return
     */
    @GetMapping("/freeBoardList")
    public String freeBoard(){
        return "/community/freeBoardList";
    }


    /**
     * 게시 글쓰기 페이지
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
}
