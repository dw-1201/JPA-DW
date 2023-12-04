package com.example.dw.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypg/*")
@RequiredArgsConstructor
public class MypageController {

    @GetMapping("/main")
    public String mypg(){ return "/mypg/mypgmain";}

    @GetMapping("/petregister")
    public String petregister(){
        return "/mypg/mypgpet";
    }




}
