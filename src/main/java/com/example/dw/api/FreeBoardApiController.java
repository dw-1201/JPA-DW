package com.example.dw.api;


import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/communities/*")
public class FreeBoardApiController {

    private final FreeBoardService freeBoardService;
    private final FreeBoardRepositoryCustom freeBoardRepositoryCustom;

//    @GetMapping("/freeBoardList/{page}?sort=${sort}")
    @GetMapping("/freeBoardList/{page}")
    public Page<FreeBoardDto> freeBoardDtoList(
            @PathVariable("page") int page,
            @RequestParam(value = "keyword", required = false) String keyword) {

        Pageable pageable = PageRequest.of(page, 10);

        System.out.println("자유게시판 키워드: " + keyword);

        Page<FreeBoardDto> result = freeBoardRepositoryCustom.findFreeBoardListBySearch(pageable, keyword);

        // 댓글 수를 추가
        List<FreeBoardDto> updatedList = result.getContent().stream()
                .map(dto -> {
                    Long commentCount = freeBoardService.countCommentsByFreeBoardId(dto.getId());
                    dto.setFreeBoardCommentCount(commentCount);

                    // 댓글 수를 출력
                    System.out.println("게시물 ID: " + dto.getId() + ", 댓글 수: " + commentCount);
                    return dto;
                })
                .collect(Collectors.toList());

        System.out.println("자유게시판 글 개수 : " + result.stream().count());

        return new PageImpl<>(updatedList, pageable, result.getTotalElements());
    }


}
