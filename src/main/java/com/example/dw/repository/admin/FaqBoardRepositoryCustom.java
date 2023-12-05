package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FaqBoardRepositoryCustom {

    Page<FaqBoardDto> findFaqListBySearch(Pageable pageable, SearchForm searchForm);

}
