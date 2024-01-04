package com.example.dw.controller;


import com.example.dw.domain.dto.admin.PetDetailResultDto;
import com.example.dw.domain.dto.admin.UserDetailDto;
import com.example.dw.domain.dto.admin.UserDetailListDto;
import com.example.dw.domain.form.PetForm;
import com.example.dw.domain.form.PetUpdateForm;
import com.example.dw.domain.form.UserUpdateForm;
import com.example.dw.repository.pet.PetRepositoryCustom;
import com.example.dw.repository.user.UsersRepository;
import com.example.dw.repository.user.UsersRepositoryCustom;
import com.example.dw.repository.user.UsersRepositoryImpl;
import com.example.dw.service.FileService;
import com.example.dw.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/mypg/*")
@RequiredArgsConstructor
public class MypageController {

    private final UsersRepositoryCustom usersRepositoryCustom;
    private final MypageService mypageService;
    private final PetRepositoryCustom petRepositoryCustom;
    private final FileService fileService;
    @GetMapping("/main/{userId}")
    public String mypg(@PathVariable("userId")Long userId, Model model){
        System.out.println(userId +"회원 정보");

        Optional<UserDetailListDto> userDetailDto=usersRepositoryCustom.findOneByUserId(userId);
        userDetailDto.ifPresent(userDetails -> System.out.println(userDetails.toString() + " 회원입니다."));

        userDetailDto.ifPresent( userDetails -> model.addAttribute("userDetail",userDetails));

        return "/mypg/mypgmain";
    }

    @GetMapping("/modify/{userId}")
    public String modifyPage(@PathVariable("userId") Long userId, Model model){
        System.out.println(userId +"회원 정보");

        Optional<UserDetailListDto> userDetailDto=usersRepositoryCustom.findOneByUserId(userId);
        userDetailDto.ifPresent(userDetails -> System.out.println(userDetails.toString() + " 회원입니다."));

        userDetailDto.ifPresent( userDetails -> model.addAttribute("userDetail",userDetails));


        return  "/mypg/userupdate";
    }

    @PutMapping("/modify/{userId}/register")
    public RedirectView modifyUser(@PathVariable("userId") Long userId,
                                   UserUpdateForm userUpdateForm,
                                   @RequestParam("userFile")MultipartFile file)throws IOException {
        System.out.println(file+"파일이름");
        userUpdateForm.setId(userId);
        System.out.println("user 번호 : "+ userUpdateForm.getId());

        mypageService.modify(userUpdateForm,file);
        System.out.println("여기까지 완료!!");

        return new RedirectView("/mypg/main/{userId}");
    }

    /**
     * mypage petList 나의 펫 등록 페이지
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/mypet/{userId}")
    public String petList(@PathVariable("userId")Long userId,Model model){

        System.out.println(userId+"입니다.");
        List<PetDetailResultDto> petDetailResultDtoList = petRepositoryCustom.findAllById(userId);

        petDetailResultDtoList.forEach(r-> System.out.println(r.getUserId()+"의"+r.getName()+"입니다."));
        System.out.println(petDetailResultDtoList.toString()+"----");
        model.addAttribute("pet",petDetailResultDtoList);
        return "/mypg/mypgpet";
    }

    /**
     * 펫 등록 페이지 이동
     * @return
     */
    @GetMapping("/mypetregister")
    public String petRegister(){
        return "/mypg/registerpet";
    }

    /**
     * 페이지 등록
     * @param petForm
     * @param userId
     * @return
     * @throws IOException
     */
    @PostMapping("/petregister")
    public String register(PetForm petForm,
                                 @RequestParam("petImg")List<MultipartFile> files,
                                 @RequestParam("userId") Long userId
    )throws IOException{


        Long id = mypageService.register(petForm);
        System.out.println(id+"====");

        fileService.registerPetImg(files, id);
        System.out.println("pet 등록 페이지 유저 "+userId);
        return "redirect:/mypg/mypet/" + userId;

    }

    /**
     * 등록 펫 기본정보를 가지고 수정 페이지 이동
     * @param petId
     * @param model
     * @return
     */
    @GetMapping("/petupdate/{petId}")
    public String petupdatePage(@PathVariable("petId") Long petId,
            @RequestParam("userId") Long userId, Model model){

       Optional<PetDetailResultDto> petDetail = petRepositoryCustom.findByPetIdAndUserId(petId,userId);

        System.out.println(petDetail.get().toString());

        petDetail.ifPresent(details -> model.addAttribute("detail",details));



        return "/mypg/registerpetupdate";
    }

    @PutMapping("/petmodify/{petId}")
    public RedirectView modifyUser(@PathVariable("petId") Long petId,
                                    PetUpdateForm petUpdateForm,
                                   @RequestParam("petImg")List<MultipartFile> files)throws IOException {
        System.out.println(files+"파일이름");
        petUpdateForm.setId(petId);
        Long userId = petUpdateForm.getUserId();
        System.out.println("pet 번호 : "+ petUpdateForm.getId());

        mypageService.modifyPet(petUpdateForm,files);
        System.out.println("여기까지 완료!!");

        return new RedirectView("/mypg/mypet/"+userId);
    }


    @GetMapping("/writepage/{userId}")
    public String writePage(){


        return "/mypg/mywrite";
    }

    @GetMapping("/myfreeboard/{userId}")
    public String myfreeboard(){

        return "/mypg/myfreeboard";
    }
}
