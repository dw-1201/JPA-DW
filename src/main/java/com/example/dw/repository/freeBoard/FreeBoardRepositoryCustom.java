package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FreeBoardRepositoryCustom {

    Page<FreeBoardDto> findFreeBoardListBySearch(Pageable pageable, String keyword);
}
