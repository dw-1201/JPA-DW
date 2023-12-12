package com.example.dw.controller;

import com.example.dw.domain.dto.community.FreeBoardDetailDto;
import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FreeBoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/community/*")
public class FreeBoardController {

    private FreeBoardService freeBoardService;
    private FreeBoardRepositoryCustom freeBoardRepositoryCustom;
    private final HttpSession httpSession;

    @Autowired
    public FreeBoardController(FreeBoardService freeBoardService, HttpSession httpSession, FreeBoardRepositoryCustom freeBoardRepositoryCustom) {
        this.freeBoardService = freeBoardService;
        this.httpSession = httpSession;
        this.freeBoardRepositoryCustom = freeBoardRepositoryCustom;
    }
    //Controller에서 ervice를 주입받고,
    //검색 결과를 "/community/freeBoardList/search" 뷰로 전달할 수 있게

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

        System.out.println("[자유게시판 상세 페이지] : "+result.toString());
        model.addAttribute("detail",result);

        return "/community/freeBoardDetail";
    }

}
