package com.example.dw.controller;


import com.example.dw.entity.dto.UsersForm;
import com.example.dw.entity.user.Users;
import com.example.dw.repository.UsersRepository;
import com.example.dw.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    //로그인창 이동
    @GetMapping("/enterLogin")
    public String login(){
        return "/user/login";
    }

    //회원가입 창 이동
    @GetMapping("/join")
    public String joinPage() {
        return "/user/join";
    }


    //회원가입
    @PostMapping("/createUser")
    public String save(UsersForm usersForm){

        System.out.println("[ 회원 가입 정보 ]: " + usersForm.toString());
        usersService.join(usersForm);
        return "/user/login";
    }

    //로그인
    @PostMapping("/login")
    public RedirectView login(String userAccount, String userPassword, HttpServletRequest req, RedirectAttributes redirectAttributes){
        Users users;
        try {
            users = usersService.login(userAccount, userPassword);
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("isNotLogin", "0");
            return new RedirectView("/user/enterLogin");
        }

        req.getSession().setAttribute("userId", users.getId());
        req.getSession().setAttribute("userAccount", users.getUserAccount());
        req.getSession().setAttribute("userName", users.getUserName());

        return new RedirectView("/index/");

    }

    //로그아웃
    @PostMapping("/logout")
    public String logout(HttpServletRequest req){
        HttpSession session = req.getSession(false);
        if(session != null){
            session.invalidate();
        }
        return "redirect:/index/";
    }

}
