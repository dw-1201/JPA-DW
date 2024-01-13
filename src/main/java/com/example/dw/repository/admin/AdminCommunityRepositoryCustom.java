package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminFreeBoardList;
import com.example.dw.domain.dto.admin.AdminQnaBoardList;
import com.example.dw.domain.dto.admin.AdminQnaDetailResultDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminCommunityRepositoryCustom {



    Page<AdminQnaBoardList> qnaBoardList(Pageable pageable, SearchForm searchForm);

    Page<AdminFreeBoardList> freeBoardList(Pageable pageable, SearchForm searchForm);

    AdminQnaDetailResultDto qnaDetail(Long qnaId);



}
