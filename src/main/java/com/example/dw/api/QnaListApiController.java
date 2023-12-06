package com.example.dw.api;


import lombok.RequiredArgsConstructor;

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
