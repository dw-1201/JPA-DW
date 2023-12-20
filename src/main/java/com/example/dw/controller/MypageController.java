package com.example.dw.controller;


import com.example.dw.domain.dto.admin.UserDetailDto;
import com.example.dw.repository.user.UsersRepository;
import com.example.dw.repository.user.UsersRepositoryCustom;
import com.example.dw.repository.user.UsersRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/mypg/*")
@RequiredArgsConstructor
public class MypageController {

    private final UsersRepositoryCustom usersRepositoryCustom;

    @GetMapping("/main/{userId}")
    public String mypg(@PathVariable("userId")Long userId, Model model){
        System.out.println(userId +"회원 정보");

       Optional<UserDetailDto> userDetailDto = usersRepositoryCustom.findByUserId(userId);

        System.out.println( userDetailDto+" 회원입니다.");
        userDetailDto.ifPresent( userDetail -> model.addAttribute("userDetail",userDetail));

        return "/mypg/mypgmain";
    }

    @GetMapping("/modify/{userId}")
    public String modifyPage(@PathVariable("userId") Long userId, Model model){
        Optional<UserDetailDto> userDetailDto = usersRepositoryCustom.findByUserId(userId);

        System.out.println( userDetailDto+" 회원입니다.");
        userDetailDto.ifPresent( userDetail -> model.addAttribute("userDetail",userDetail));

        return  "/mypg/userupdate";
    }

    @PutMapping("/modify/{userId}/register")
    public RedirectView modifyUser(@PathVariable("userId") Long userId,
                                   @RequestParam("userFile")MultipartFile file){

        return new RedirectView("/mypg/main/{userId}");
    }

    @GetMapping("/petregister")
    public String petregister(){
        return "/mypg/mypgpet";
    }




}
