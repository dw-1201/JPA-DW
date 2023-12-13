package com.example.dw.controller;


import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.JoinForm;
import com.example.dw.repository.user.UsersRepository;
import com.example.dw.service.UsersService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;
    private final UsersRepository usersRepository;


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
    public RedirectView login(String userAccount, String userPassword, HttpServletRequest req, RedirectAttributes redirectAttributes) {
        Users users;


        try {
            users = usersService.login(userAccount, userPassword);

            // 로그인 성공 시 userState가 1인지 확인
            if (users.getUserState() == 1) {
                req.getSession().setAttribute("userId", users.getId());
                req.getSession().setAttribute("userAccount", users.getUserAccount());
                req.getSession().setAttribute("userName", users.getUserName());
                return new RedirectView("/index/");
            } else {
                // userState가 1이 아니면 로그인 실패 처리
                redirectAttributes.addFlashAttribute("isNotLogin", "0");
                return new RedirectView("/user/enterLogin");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("isNotLogin", "0");
            return new RedirectView("/user/enterLogin");
        }
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



    //계정찾기 페이지 이동
    @GetMapping("/findAccount")
    public String findAccountPage(){
        return "/user/findId";
    }

    //계정 찾기
    @ResponseBody
    @PostMapping("/accountCheck")
    public boolean accountCheck(String userName, String userPhone, String userEmail){

        boolean accountCheck = usersRepository.existsByUserNameAndUserEmailAndUserPhone(userName, userEmail, userPhone);
        return accountCheck;
    }

    //비밀번호 찾기 페이지 이동
    @GetMapping("/findPw")
    public String findPwPage(){
        return "/user/findPw";
    }

    //비밀번호 찾기
    @ResponseBody
    @PostMapping("/accountCheckForPw")
    public boolean accountCheckForPw(String userName, String userAccount, String userEmail){

        boolean accountCheck = usersRepository.existsByUserNameAndUserAccountAndUserEmail(userName, userAccount, userEmail);
        return accountCheck;

    }



}
