package com.example.dw.api;


import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.dto.community.QuestionDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.community.QuestionRepositoryCuston;
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
@RequestMapping("/qnar/*")
public class QnaListApiController {
//    private final QuestionRepositoryCuston questionRepositoryCuston;

//    @GetMapping("/qnalist/{page}")
//    public Page<QuestionDto> pagelist(
//            @PathVariable("page") int page, SearchForm searchForm
//    ){
//        Pageable pageable = PageRequest.of(page, 5);
//
//        Page<QuestionDto> result = questionRepositoryCuston.findQnaListBySearch(pageable,searchForm);
//
//        System.out.println(result.toString());
//
//
//
//        return result;
//
//    }



}
