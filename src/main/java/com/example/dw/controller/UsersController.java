package com.example.dw.controller;


import com.example.dw.domain.form.JoinForm;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    public String save(JoinForm joinForm){


        System.out.println("[ 회원 가입 정보 ]: " + joinForm.toString());
        usersService.join(joinForm);
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
