package com.example.dw.api;


import com.example.dw.service.MypageService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping()
public class MypageApiController {

    private final MypageService mypageService;

    @PostMapping("/mypgs/phone/check")
    public boolean checkPhoneDuplication(@RequestParam("userPhone") String userPhone){
        if (userPhone == null) {
            throw new IllegalArgumentException("폰 번혼 누락");

        }
        System.out.println("기입된 전화번호 : " + userPhone);
        if(mypageService.existsByUserPhone(userPhone) == true ){
            return false;
        }else {
            return true;
        }
    }

    @PostMapping("/mypgs/nickname/check")
    public boolean checkNickNameDuplication(@RequestParam("userNickName") String userNickName){
        if (userNickName == null) {
            throw new IllegalArgumentException("별칭 누락");

        }
        System.out.println("기입된 닉네임 : " + userNickName);
        if(mypageService.existsByUserNicName(userNickName)== true ){
            return false;
        }else {
            return true;
        }
    }
}
