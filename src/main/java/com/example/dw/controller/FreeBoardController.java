package com.example.dw.controller;

import com.example.dw.domain.form.FreeBoardWritingForm;
import com.example.dw.service.FreeBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/community/*")
public class FreeBoardController {

    private FreeBoardService freeBoardService;

    @Autowired
    public FreeBoardController(FreeBoardService freeBoardService) {
        this.freeBoardService = freeBoardService;
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
//    @GetMapping("")
//    public String freeBoardList(Model model){
//        List<FreeBoard> freeBoardDtoList = freeBoardService.getFreeBoardList();
//        freeBoardDtoList.stream()
//                .map(o -> new FreeBoardDto(o.getId(),o.getFreeBoardTitle(),o.getFreeBoardContent())
//        model.addAttribute("freeBoardList",freeBoardDtoList);
//
//        return "/community/freeBoardList";
//    }


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
        System.out.println(freeBoardWritingForm.getFreeBoardTitle());
        System.out.println(freeBoardWritingForm.getFreeBoardContent());
        freeBoardService.saveFreeBoard(freeBoardWritingForm);
        return "redirect:/community/freeBoardList";
    }
}
