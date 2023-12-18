package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminNoticeBoardDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoticeBoardRepositoryCustom {

    Page<AdminNoticeBoardDto> findNoticeListBySearch(Pageable pageable, SearchForm searchForm);

}
