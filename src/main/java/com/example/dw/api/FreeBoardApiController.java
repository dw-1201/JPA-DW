package com.example.dw.api;


import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/communities/*")

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
            @RequestParam(value = "keyword", required = false)
                    String keyword) {

        Pageable pageable = PageRequest.of(page, 5);

        System.out.println("자유게시판 키워드: " + keyword);

        Page<FreeBoardDto> result = freeBoardRepositoryCustom.findFreeBoardListBySearch(pageable, keyword);

        System.out.println("자유게시판 글 개수 : "+result.stream().count());


        for (FreeBoardDto freeBoardDto : result.getContent()) {
            System.out.println("자유게시판 번호: " + freeBoardDto.getId());
            System.out.println("자유게시판 제목: " + freeBoardDto.getFreeBoardTitle());
        }

        return result;
    }


}
