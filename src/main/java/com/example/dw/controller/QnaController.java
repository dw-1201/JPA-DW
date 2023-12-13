package com.example.dw.controller;


import com.example.dw.domain.form.QuestionWritingForm;
import com.example.dw.repository.community.QuestionRepository;
import com.example.dw.service.FileService;
import com.example.dw.service.QnaService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/qna/*")
public class QnaController {

    private final FileService fileService;
    private final QuestionRepository questionRepository;
    private final QnaService qnaService;
    private final HttpSession httpSession;

    @GetMapping("/qnaLists")
    public String page(){

        System.out.println("여기는 controller");
        return "/community/qnaList";
    }

    @GetMapping("/qnawrite")
    public String qnawrite(){


        return "/community/writingQna";
    }


    @PostMapping("/qnaregister")
    public RedirectView write(QuestionWritingForm questionWritingForm,
                              @RequestParam("questionImg")List<MultipartFile> files

    ) throws IOException
    {
        //정보 확인
        System.out.println("[qna 등록 정보] :"+ questionWritingForm.toString());
        files.forEach(r-> System.out.println("[파일목록] : "+r.getOriginalFilename()));

        Long id = qnaService.register(questionWritingForm);
        System.out.println(questionWritingForm.getUserId()+"유저 아이디");

        System.out.println(questionWritingForm.getUserId()+"");

        fileService.registerquestionImg(files, id);
        System.out.println(id);
        System.out.println("여기는 어디게~!");
        return new RedirectView("/qna/qnaLists");
    }
}
