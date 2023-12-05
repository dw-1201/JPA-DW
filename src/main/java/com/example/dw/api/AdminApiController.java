package com.example.dw.api;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.form.SearchFaqForm;
import com.example.dw.repository.admin.FaqBoardRepositoryCustom;
import com.example.dw.repository.admin.FaqBoardRepositoryImpl;
import com.example.dw.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admins/*")
public class AdminApiController {

    private final AdminService adminService;
    private final FaqBoardRepositoryCustom faqBoardRepositoryCustom;

    //faq조회
    @GetMapping("/noticeList")
    public List<FaqBoardDto> findFaqList(SearchFaqForm searchFaqForm){

        System.out.println("넘어온 카테고리 : "+searchFaqForm.getCate());
        System.out.println("넘어온 키워드 :  "+searchFaqForm.getKeyword());

        List<FaqBoardDto> result = faqBoardRepositoryCustom.findFaqListBySearch();

        System.out.println(result.toString());
//        List<FaqBoardDto> lists =
//                adminService.faqList().stream().map(o-> new FaqBoardDto(o.getId(),
//                o.getFaqBoardTitle(), o.getFaqBoardContent(),
//                o.getFaqBoardViewCount(), o.getFaqBoardRd(),o.getFaqBoardRd())).
//                collect(Collectors.toList());
//
//        System.out.println(lists.toString());
        return result;
    }



}
