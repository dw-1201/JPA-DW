package com.example.dw.api;


import com.example.dw.domain.dto.community.QuestionDto;
import com.example.dw.repository.community.QuestionRepositoryCuston;
import com.example.dw.repository.community.QuestionRepositoryImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qnar/*")
public class QnaListApiController {
    private final QuestionRepositoryCuston questionRepositoryCuston;

    @GetMapping("/qnalist")
    public List<QuestionDto> getList(){
        List<QuestionDto> list =questionRepositoryCuston.findQnaListBySearch();
        System.out.println(list +"안뇽");

        return list;

    }



}
