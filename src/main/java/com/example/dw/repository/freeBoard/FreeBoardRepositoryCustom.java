package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardDetailDto;
import com.example.dw.domain.dto.community.FreeBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FreeBoardRepositoryCustom {

    Page<FreeBoardDto> findFreeBoardListBySearch(Pageable pageable, String keyword);

    List<FreeBoardDetailDto> findFreeBoardById(Long id);

//    Page<FreeBoardDto> findFreeBoardListBySearchAndSort(Pageable pageable, String keyword, String sort);
}
