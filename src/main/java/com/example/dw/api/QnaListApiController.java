package com.example.dw.api;


import com.example.dw.domain.dto.community.QuestionListDto;
import com.example.dw.repository.community.QuestionRepositoryCustom;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/qnar/*")
public class QnaListApiController {
    private final QuestionRepositoryCustom questionRepositoryCustom;

    @Value("${file.que}")
    private String filequeImg;

    @GetMapping("/queImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(filequeImg, fileFullPath));
    }


    @GetMapping("/qnalist/{page}")
    public Page<QuestionListDto> findQnAList(
            @PathVariable("page") int page, String keyword){
        Pageable pageable = PageRequest.of(page,5);
        Page<QuestionListDto> result = questionRepositoryCustom.findQnaListBySearch(pageable,keyword);
        System.out.println(result+"안뇽");
        System.out.println(keyword+"검색 내용!");
        System.out.println("여기는 레스트");



        return result;

    }



}
