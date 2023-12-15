package com.example.dw.api;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.dto.admin.NoticeBoardDto;
import com.example.dw.domain.dto.admin.UserChartDto;
import com.example.dw.domain.dto.user.UserListDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.admin.FaqBoardRepositoryCustom;
import com.example.dw.repository.admin.NoticeBoardRepositoryCustom;
import com.example.dw.repository.user.UsersRepositoryCustom;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/admins/*")
public class AdminApiController {

    private final FaqBoardRepositoryCustom faqBoardRepositoryCustom;
    private final NoticeBoardRepositoryCustom noticeBoardRepositoryCustom;
    private final UsersRepositoryCustom usersRepositoryCustom;

    //faq조회
    @GetMapping("/faqList/{page}")
    public Page<FaqBoardDto> findFaqList(
            @PathVariable("page") int page,
            SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 5);

        Page<FaqBoardDto> result = faqBoardRepositoryCustom.findFaqListBySearch(pageable, searchForm);

        System.out.println(result.toString());

        return result;
    }

    //공지사항 조회
    @GetMapping("/noticeList/{page}")
    public Page<NoticeBoardDto> findNoticeList(
            @PathVariable("page") int page,
            SearchForm searchForm
    ){
        Pageable pageable = PageRequest.of(page, 10);

        Page<NoticeBoardDto> result = noticeBoardRepositoryCustom.findNoticeListBySearch(pageable,searchForm);

        return result;
    }

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

    //주단위 일별 회원가입자 수
    @GetMapping("/daily")
    public List<UserChartDto> getDaily() {



        return usersRepositoryCustom.findJoinCountByAll();
    }

    //신규 가입 현황
    @GetMapping("/newUserStatus")
    public Map<String, List> status(){

        Map<String, List> status = usersRepositoryCustom.newUserStatus();


         return status;

    }





}
