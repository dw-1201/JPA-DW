package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.NoticeBoardDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeBoardRepositoryCustom {

    Page<NoticeBoardDto> findNoticeListBySearch(Pageable pageable, SearchForm searchForm);

}
