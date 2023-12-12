package com.example.dw.controller;


import com.example.dw.domain.dto.community.QuestionDto;
import com.example.dw.domain.form.QuestionForm;
import com.example.dw.repository.community.QuestionRepository;
import com.example.dw.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/qna/*")
public class QnaController {

    private final QnaService qnaService;
    private final QuestionRepository questionRepository;

    @GetMapping("/qmain")
    public String page(){


        return "/community/qnaList";
    }

    @GetMapping("/qnawrite")
    public String qnawrite(){
        return "/community/writingQna";
    }


    @PostMapping("/qnawriteform")
    public RedirectView write(QuestionForm questionForm){
        System.out.println(questionForm.getQuestionTitle());
        System.out.println(questionForm.getQuestionContent());
        qnaService.writer(questionForm);

        return new RedirectView("qna/qmain");
    }
}
