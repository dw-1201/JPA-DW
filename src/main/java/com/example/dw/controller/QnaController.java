package com.example.dw.controller;


import com.example.dw.domain.dto.community.QuestionDetailResultDto;
import com.example.dw.domain.form.QuestionWritingForm;
import com.example.dw.repository.community.QuestionRepository;
import com.example.dw.repository.community.QuestionRepositoryCustom;
import com.example.dw.service.FileService;
import com.example.dw.service.QnaService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final QuestionRepositoryCustom questionRepositoryCustom;
    private final QnaService qnaService;

    @GetMapping("/qnaLists")
    public String page(){

//        System.out.println("여기는 controller");
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

    @GetMapping("/qnaDetail/{questionId}")
    public String detailPage(@PathVariable("questionId") Long questionId , Model model){
        qnaService.updateViewCount(questionId);

        List<QuestionDetailResultDto> detailresult = questionRepositoryCustom.findQnaById(questionId);
       System.out.println(detailresult.toString()+"입니다.");
        model.addAttribute("detail", detailresult);
        System.out.println(questionId+"번 게시물 조회수 증가");

        return "/community/qnaDetail";
    }
//
//    // 수정중
    @GetMapping("/modify/{questionId}")
    public String modifyPage(@PathVariable("questionId") Long questionId,Model model){
        System.out.println(questionId+ "입니다.");
        List<QuestionDetailResultDto> result = questionRepositoryCustom.findQnaById(questionId);
        System.out.println(result.toString()+"입니다.");
        model.addAttribute("question", result);

        return "/community/writingModifyQna";


    }

//    // 게시판 수정
    @PutMapping("/modify/{questionId}/edit")
    public RedirectView questionModify(@PathVariable("questionId") Long questionId,
                                       QuestionWritingForm questionWritingForm,
                                       @RequestParam("questionImg") List<MultipartFile> files) throws IOException{

        questionWritingForm.setId(questionId);
        System.out.println("qna 번호 : "+ questionWritingForm.getId());

        qnaService.modify(questionWritingForm,files);
        System.out.println("여기까지 완료!!");
        return new RedirectView("/qna/qnaLists");
    }

    // 게시판 삭제
    @GetMapping("/delete/{questionId}")
    public RedirectView removeQuestion(@PathVariable("questionId") Long questionId){

        qnaService.delete(questionId);

        return new RedirectView("/qna/qnaLists");
    }

}
