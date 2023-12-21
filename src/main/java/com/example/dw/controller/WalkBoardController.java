package com.example.dw.controller;


import com.example.dw.domain.form.WalkMateForm;
import com.example.dw.service.WalkingMateService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/walk")
public class WalkBoardController {


    private final WalkingMateService walkingMateService;

    //산책글 리스트 페이지 이동
    @GetMapping("/walkList")
    public String walkList(){
        return "/community/walkingMateList";
    }

    //글 작성 페이지 이동
    @GetMapping("/walkWrite")
    public String walkWrite(){
        return "/community/walkingMateWrite";
    }


    //글작성 완료
    @PostMapping("/registerWalkMate")
    public RedirectView registerWalk(WalkMateForm walkMateForm, HttpSession session){


        Long userId = (Long)session.getAttribute("userId");
        walkMateForm.setUserId(userId);
        System.out.println(walkMateForm.toString());

        walkingMateService.registerWalkingMate(walkMateForm);
        return new RedirectView("/walk/walkList");
    }


    @GetMapping("/detail/{id}")
    public String walkDetail(@PathVariable("id") Long id, Model model ){





        return "/community/walkingMateDetail";
    }

}
