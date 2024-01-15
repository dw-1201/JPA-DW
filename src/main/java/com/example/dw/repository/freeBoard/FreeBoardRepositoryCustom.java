package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardImgDto;
import com.example.dw.domain.dto.community.FreeBoardListDto;
import com.example.dw.domain.dto.community.FreeBoardResultDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FreeBoardRepositoryCustom {

    //자유게시판 리스트 조회(페이징, 검색)
    Page<FreeBoardListDto> findFreeBoardListBySearch(Pageable pageable, String keyword);

    //자유게시판 상세페이지 조회
    List<FreeBoardResultDetailDto> findFreeBoardById(Long id);

    //자유게시판 이미지 조회
    List<FreeBoardImgDto> findFreeBoardImgByFreeBoardId(Long freeBoardId);

//    Page<FreeBoardListDto> findFreeBoardListById(Pageable pageable, Long userId);

}
