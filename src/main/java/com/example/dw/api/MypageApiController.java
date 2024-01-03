package com.example.dw.api;


import com.example.dw.repository.pet.PetRepository;
import com.example.dw.service.MypageService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/mypgs/name/check")
    public boolean checkPetNameDuplication(@RequestParam("name") String name,
                                            @RequestParam("userId")Long userId){
        if (name == null || userId == null) {
            throw new IllegalArgumentException("누락");

        }
        System.out.println("기입된 닉네임 : " + name);
        System.out.println("조회 아이디 : "+ userId);
        if(mypageService.existsByPetName(name,userId)== true ){
            return false;
        }else {
            return true;
        }
    }


    @PostMapping("/mypgs/remove/{petId}")
    public void petInfoDelete(@PathVariable("petId") Long petId){
        System.out.println("[삭제 펫 정보 ] :" + petId);
            mypageService.removePet(petId);

        System.out.println(petId+"정보사 삭제되었습니다.");


    }


}
