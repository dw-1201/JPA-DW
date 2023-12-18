package com.example.dw.api;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.dto.admin.NoticeBoardDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.admin.FaqBoardRepositoryCustom;
import com.example.dw.repository.admin.NoticeBoardRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admins/*")
public class AdminNoticeApiController {

    private final FaqBoardRepositoryCustom faqBoardRepositoryCustom;
    private final NoticeBoardRepositoryCustom noticeBoardRepositoryCustom;

    //faq조회
    @GetMapping("/faqList/{page}")
    public Page<FaqBoardDto> findFaqList(
            @PathVariable("page") int page,
            SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 5);

        Page<FaqBoardDto> result = faqBoardRepositoryCustom.findFaqListBySearch(pageable, searchForm);

        System.out.println(result.toString());

        return result;
    }

    //공지사항 조회
    @GetMapping("/noticeList/{page}")
    public Page<NoticeBoardDto> findNoticeList(
            @PathVariable("page") int page,
            SearchForm searchForm
    ){
        Pageable pageable = PageRequest.of(page, 10);

        Page<NoticeBoardDto> result = noticeBoardRepositoryCustom.findNoticeListBySearch(pageable,searchForm);

        return result;
    }







}
