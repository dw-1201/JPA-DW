package com.example.dw.controller;


import com.example.dw.domain.form.QnaBoardForm;
import com.example.dw.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/qna/*")
public class QnaController {

    private final QnaService qnaService;


    @GetMapping("/qmain")
    public String page(){


        return "/community/qnaList";
    }

    @GetMapping("/qnawrite")
    public String qnawrite(){
        return "/community/writingQna";
    }


    @PostMapping("/qnawriteform")
    public RedirectView write(QnaBoardForm qnaBoardForm){
        System.out.println(qnaBoardForm.getQuestionTitle());
        System.out.println(qnaBoardForm.getQuestionContent());
        qnaService.writer(qnaBoardForm);

        return new RedirectView("qna/qmain");
    }
}
