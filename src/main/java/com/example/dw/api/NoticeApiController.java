package com.example.dw.api;


import com.example.dw.domain.dto.admin.AdminNoticeBoardDto;
import com.example.dw.domain.dto.community.FreeBoardListDto;
import com.example.dw.domain.dto.notice.NoticeListDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.admin.NoticeBoardRepositoryCustom;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FreeBoardService;
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
@RequestMapping("/notices/*")
public class NoticeApiController {

    private final NoticeBoardRepositoryCustom noticeBoardRepositoryCustom;
    /**
     * 자유게시판 리스트
     * 페이징, 키워드 검색
     */
    @GetMapping("/notice/{page}")
    public Page<NoticeListDto> noticeBoardListDto(
            @PathVariable("page") int page, String keyword) {

        System.out.println("공지사항 키워드: " + keyword);

        Pageable pageable = PageRequest.of(page, 10);
        Page<NoticeListDto> result = noticeBoardRepositoryCustom.findNoticeBoardListBySearch(pageable, keyword);
        System.out.println("공지사항 글 개수 : " + result.stream().count());

        return result;
    }

}
