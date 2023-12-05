package com.example.dw.api;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.admin.FaqBoardRepositoryCustom;
import com.example.dw.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admins/*")
public class AdminApiController {

    private final AdminService adminService;
    private final FaqBoardRepositoryCustom faqBoardRepositoryCustom;

    //faq조회
    @GetMapping("/noticeList/{page}")
    public Page<FaqBoardDto> findFaqList(
            @PathVariable("page") int page,
            SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 5);

        System.out.println("넘어온 카테고리 : "+ searchForm.getCate());
        System.out.println("넘어온 키워드 :  "+ searchForm.getKeyword());

        Page<FaqBoardDto> result = faqBoardRepositoryCustom.findFaqListBySearch(pageable, searchForm);
        System.out.println(result.stream().count());

        System.out.println(result.toString());

        return result;
    }



}
