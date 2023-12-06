package com.example.dw.repository.freeBoard;

import com.example.dw.domain.dto.community.FreeBoardDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FreeBoardRepositoryCustom {

    Page<FreeBoardDto> findFreeBoardListBySearch(Pageable pageable, SearchForm searchForm);
}
