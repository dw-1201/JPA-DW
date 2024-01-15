package com.example.dw.api;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.dto.community.WalkMateListDto;
import com.example.dw.domain.form.SearchCateLocationForm;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.service.AdminCommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminCommunityApiController {



    private final AdminCommunityService adminCommunityService;





    //qna리스트
    @GetMapping("/qnaList/{page}")
    public Page<AdminQnaBoardList> qnaList(
            @PathVariable("page") int page
            ,SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 15);

        return adminCommunityService.qnaBoardList(pageable, searchForm);
    }


    //qna상세
    @GetMapping("/questionDetail/{qnaId}")
    public AdminQnaDetailResultDto qnaDetail(@PathVariable("qnaId")Long qnaId){

        return adminCommunityService.qnaBoardDetail(qnaId);
    }

    //자유게시판 리스트
    @GetMapping("/freeBoardList/{page}")
    public Page<AdminFreeBoardList> freeBoardList(
            @PathVariable("page") int page, SearchForm searchForm
    ){

        Pageable pageable = PageRequest.of(page, 15);

        return adminCommunityService.freeBoardList(pageable, searchForm);

    }




    //관리자 산책글 리스트
    @GetMapping("/walkList/{page}")
    public Page<WalkMateListDto> showWalkList(@PathVariable("page") int page,
                                              SearchCateLocationForm searchCateLocationForm){

        System.out.println("[관리자 산책글 리스트] :  "+searchCateLocationForm.toString());


        Page<WalkMateListDto> result = adminCommunityService.walkMateList(page, searchCateLocationForm);

        System.out.println(result.toString());

       return result;

    }

    //시험용
    @GetMapping("/walkDetail/{walkMateId}")
    public AdminWalkMateDetailDto walkMateDetail(@PathVariable("walkMateId") Long walkMateId){
        AdminWalkMateDetailDto adminWalkMateDetailDto = adminCommunityService.walkMateDetailPage(walkMateId);

        return adminWalkMateDetailDto;
    }


    //시험용-자유상세
    @GetMapping("/freeBoardDetail/{freeBoardId}")
    public AdminFreeDetailResultDto freeBoardDetail(@PathVariable("freeBoardId") Long freeBoardId){

        return adminCommunityService.freeBoardDetail(freeBoardId);
    }
}
