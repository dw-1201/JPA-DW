package com.example.dw.controller;

import com.example.dw.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class UsersRestController {

    private final UsersService usersService;

    //아이디 중복체크
    @PostMapping("/users/account/check")
    public boolean checkAccountDuplication(@RequestParam(value = "userAccount") String userAccount) {
        if (userAccount == null) {
            throw new IllegalArgumentException("희망 이이디 입력 누락");
        }

        System.out.println("가입 시 입력한 희망 아이디 :" + userAccount);

        if (usersService.existsByUserAccount(userAccount) == true) {
            return false;
        } else {
            return true;
        }
    }

    //이메일 중복 체크
    @PostMapping("/users/email/check")
    public boolean checkEmailDuplication(@RequestParam("userEmail") String userEmail){
        if (userEmail == null) {
            throw new IllegalArgumentException(("이메일 입력 누락"));
        }
        System.out.println("기입된 이메일 : " + userEmail);

        if(usersService.existsByUserEmail(userEmail)==true){
            System.out.println("중복된 이메일입니다.");
            return false;
        }else {
            return true;
        }
    }

    //휴대폰 번호 중복 체크
    @PostMapping("/users/phone/check")
    public boolean checkPhoneDuplication(@RequestParam("userPhone") String userPhone){
        if (userPhone == null) {
            throw new IllegalArgumentException("폰 번혼 누락");

        }
        System.out.println("기입된 전화번호 : " + userPhone);
        if(usersService.existsByUserPhone(userPhone) == true ){
            return false;
        }else {
            return true;
        }
    }


}