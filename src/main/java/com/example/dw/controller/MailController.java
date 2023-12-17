package com.example.dw.controller;

import com.example.dw.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mail/*")
public class MailController {

    private final MailService mailService;


    @ResponseBody
    @PostMapping("/mail")
    public String mailSend(String mail){

        int number = mailService.sendMail(mail);

        return number +"";
    }

    @ResponseBody
    @PostMapping("/userAccountCheck")
    public String accountFind(String userName, String userPhone, String userEmail){

        int number = mailService.reworkAccountMail(userName, userEmail, userPhone);

        String num = "" + number;

                return num;

    }

    @ResponseBody
    @PostMapping("/userPassword")
    public String passwordFind(String userName, String userAccount, String userEmail){


        int number =mailService.reworkPwMail(userName, userAccount, userEmail);

        return number + "";

    }


}
