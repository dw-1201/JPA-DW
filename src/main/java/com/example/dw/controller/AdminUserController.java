package com.example.dw.controller;

import com.example.dw.domain.dto.admin.UserDetailDto;
import com.example.dw.domain.entity.user.Users;
import com.example.dw.repository.user.UsersRepository;
import com.example.dw.repository.user.UsersRepositoryCustom;
import com.example.dw.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminUserController {

    private final UsersRepository usersRepository;
    private final UsersRepositoryCustom usersRepositoryCustom;
    private final AdminUserService adminUserService;


    //회원현황
    @GetMapping("/userStatus")
    public String userStatus(){
        return "/admin/adminIndex";
    }


    //회원 리스트
    @GetMapping("/userList")
    public String userList(){

        return "/admin/adminUserList";
    }

    //회원 상세 보기
    @GetMapping("/userDetail/{userId}")
    public String userDetail(@PathVariable("userId") Long userId, Model model){

        Optional<UserDetailDto> userDetail = usersRepositoryCustom.findByUserId(userId);

        //옵셔널 객체로 감싸진 경우 타임리프로 받을 수 없다.
        //따라서 ifPresent로 추출하여 모델 객체에 담아줘야함
        userDetail.ifPresent(  detail -> model.addAttribute("detail", detail));

        return "/admin/adminUserDetail";
    }

    //회원 탈퇴
    @GetMapping("/userDelete/{userId}")
    public RedirectView userDelete(@PathVariable("userId") Long userId){

        Users users = usersRepository.findById(userId).get();
        users.deleteDate();
        usersRepository.deleteById(userId);

        return new RedirectView("/admin/userList");

    }

    //회원 복구
    @GetMapping("/userRecover/{userId}")
    public RedirectView userRecover(@PathVariable("userId") Long userId){

        adminUserService.modifyUserStatus(userId);

        return new RedirectView("/admin/userList");
    }


}
