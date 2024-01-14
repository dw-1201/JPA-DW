package com.example.dw.api;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.repository.user.UsersRepositoryCustom;
import com.example.dw.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins/*")
public class AdminUserApiController {

    private final AdminUserService adminUserService;
    private final UsersRepositoryCustom usersRepositoryCustom;

    //회원목록 조회
    @GetMapping("/userList/{page}")
    public Page<UserListDto> findUserList(
            @PathVariable("page") int page,
            String userState,
            String cate, String keyword
    ){

        Pageable pageable = PageRequest.of(page, 15);

        return usersRepositoryCustom.findByAll(pageable, cate, keyword, userState);

    }


    //회원상세(통신확인용)
    @GetMapping("/userDetail/{userId}")
    public AdminUserDetailResultDto userDetail(
            @PathVariable("userId") Long userId
    ){

        return usersRepositoryCustom.findByUserId(userId);
    }
    //회원 상세 - qna 내역
    @GetMapping("/userQnaList/{userId}/{page}")
    public Page<AdminUserDetailQnaListDto> qnaList(
            @PathVariable("userId") Long userId,
            @PathVariable("page") int page
    ){
        Pageable pageable = PageRequest.of(page, 5);
        return adminUserService.qnalist(pageable, userId);
    }

    //회원 상세 -자유게시판 내역



    //회원 상세 - 산책내역
    @GetMapping("/userWalkList/{userId}/{page}")
    public Page<AdminUserDetailWalkMateDto> walkList(
            @PathVariable("userId") Long userId,
            @PathVariable("page") int page
    ){

        Pageable pageable = PageRequest.of(page, 5);

        return adminUserService.walkMateList(pageable, userId);

    }




    //회원 상세 - 주문 내역
    @GetMapping("/userOrderList/{userId}/{page}")
    public Page<AdminUserDetailOrderResultWithTotalPriceDto> orderList(@PathVariable("userId") Long userId,
                                                                  @PathVariable("page")int page){
        Pageable pageable = PageRequest.of(page, 5);

        return adminUserService.orderList(pageable,userId);
    }


    //주단위 일별 회원가입자 수
    @GetMapping("/daily")
    public List<AdminUserChartDto> getDaily() {

        return usersRepositoryCustom.findJoinCountByAll();
    }

    //신규 가입 현황
    @GetMapping("/newUserStatus")
    public Map<String, List> status(){

        Map<String, List> status = usersRepositoryCustom.newUserStatus();

        return status;

    }
}
