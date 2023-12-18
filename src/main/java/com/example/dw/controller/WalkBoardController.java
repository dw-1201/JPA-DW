package com.example.dw.controller;


import com.example.dw.domain.form.WalkMateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/walk")
public class WalkBoardController {



    @GetMapping("/walkWrite")
    public String walkWrite(){
        return "/walkingMate/walkingMateWrite";
    }


    @PostMapping("/registerWalkMate")
    public RedirectView registerWalk(WalkMateForm walkMateForm){

        System.out.println(walkMateForm.getWalkingMateTitle());
        System.out.println(walkMateForm.getWalkingMateContent());
        System.out.println(walkMateForm.getWalkingMatePerson());
        System.out.println(walkMateForm.getWalkingMateDate());
        System.out.println(walkMateForm.getWalkingMateTime());
        System.out.println(walkMateForm.getWalkingMateFullAddress());
        System.out.println(walkMateForm.getWalkCity());
        System.out.println(walkMateForm.getWalkCounty());

        return new RedirectView("/index/");

    }

}
