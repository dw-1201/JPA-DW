package com.example.dw.api;


import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/community/*")

public class FreeBoardApiController {

    private FreeBoardService freeBoardService;
    private FreeBoardRepositoryCustom freeBoardRepositoryCustom;

    @Autowired
    public FreeBoardApiController(FreeBoardService freeBoardService, FreeBoardRepositoryCustom freeBoardRepositoryCustom) {
        this.freeBoardService = freeBoardService;
        this.freeBoardRepositoryCustom = freeBoardRepositoryCustom;
    }

    @GetMapping("/freeBoardList/{page}")
    public Page<FreeBoardDto> freeBoardDtoList(
            @PathVariable("page") int page,
            SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 5);

        System.out.println("자유게시판 카테고리 : "+ searchForm.getCate());
        System.out.println("자유게시판 키워드 :  "+ searchForm.getKeyword());

        Page<FreeBoardDto> result = freeBoardRepositoryCustom.findFreeBoardListBySearch(pageable, searchForm);
        System.out.println(result.stream().count());

        System.out.println(result.toString());

        return result;
    }
}
