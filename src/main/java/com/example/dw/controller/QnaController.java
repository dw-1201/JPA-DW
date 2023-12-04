package com.example.dw.controller;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/qna/*")
public class QnaController {

    @GetMapping("/qmain")
    public String main(){
        return "/community/qnaList";
    }



}
