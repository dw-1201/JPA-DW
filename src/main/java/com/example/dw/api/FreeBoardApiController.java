package com.example.dw.api;


import com.example.dw.domain.dto.community.FreeBoardListDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.freeBoard.FreeBoardRepositoryCustom;
import com.example.dw.service.FreeBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/communities/*")
public class FreeBoardApiController {

    private final FreeBoardService freeBoardService;
    private final FreeBoardRepositoryCustom freeBoardRepositoryCustom;

    /**
     * 자유게시판 파일처리
     */
    @Value("${file.free}")
    private String fileFreeImg;

    @GetMapping("/freeImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException{
        return FileCopyUtils.copyToByteArray(new File(fileFreeImg, fileFullPath));
    }

    @Value("${file.user}")
    private String userImg;

    //유저 사진 불러오기
    @GetMapping("/freeUserImg")
    public byte[] getUserImg(String userImgPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(userImg, userImgPath));
    }

    /**
     * 자유게시판 리스트
     * 페이징, 키워드 검색
     */
    @GetMapping("/freeBoardList/{page}")
    public Page<FreeBoardListDto> freeBoardDtoList(
            @PathVariable("page") int page, SearchForm searchForm) {

        System.out.println(searchForm.getCate());
        System.out.println(searchForm.getKeyword());

        Pageable pageable = PageRequest.of(page, 5);
        Page<FreeBoardListDto> result = freeBoardRepositoryCustom.findFreeBoardListBySearch(pageable, searchForm);
        System.out.println("자유게시판 글 개수 : " + result.stream().count());

        return result;
    }

}


//    @GetMapping("/freeBoardList/{page}")
//    public Page<FreeBoardListDto> freeBoardDtoList(
//            @PathVariable("page") int page, SearchForm searchForm) {
//
//        Pageable pageable = PageRequest.of(page, 5);
//        System.out.println("자유게시판 키워드: " + searchForm);
//
//        Page<FreeBoardListDto> result = freeBoardRepositoryCustom.findFreeBoardListBySearch(pageable, searchForm);
//
//        // 댓글 수를 추가
//        List<FreeBoardListDto> updatedList = result.getContent().stream()
//                .map(dto -> {
//                    Long commentCount = freeBoardService.countCommentsByFreeBoardId(dto.getId());
//                    dto.setFreeBoardCommentCount(commentCount);
//
//                    // 댓글 수를 출력
//                    System.out.println("게시물 ID: " + dto.getId() + ", 댓글 수: " + commentCount);
//                    return dto;
//                })
//                .collect(Collectors.toList());
//
//        System.out.println("자유게시판 글 개수 : " + result.stream().count());
//
//        return new PageImpl<>(updatedList, pageable, result.getTotalElements());
//    }