package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminFaqBoardDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FaqBoardRepositoryCustom {

    Page<AdminFaqBoardDto> findFaqListBySearch(Pageable pageable, SearchForm searchForm);

}
