package com.example.dw.api;

import com.example.dw.entity.dto.admin.FaqBoardDto;
import com.example.dw.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admins/*")
public class AdminApiController {

    private final AdminService adminService;


    //faq조회
    @GetMapping("/noticeList")
    public List<FaqBoardDto> findFaqList(){


        List<FaqBoardDto> lists =
                adminService.faqList().stream().map(o-> new FaqBoardDto(o.getId(),
                o.getFaqBoardTitle(), o.getFaqBoardContent(),
                o.getFaqBoardViewCount(), o.getFaqBoardRd(),o.getFaqBoardRd())).
                collect(Collectors.toList());

        System.out.println(lists.toString());
        return lists;
    }



}
