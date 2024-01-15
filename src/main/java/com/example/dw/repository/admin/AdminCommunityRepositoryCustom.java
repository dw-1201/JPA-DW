package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminFreeBoardList;
import com.example.dw.domain.dto.admin.AdminFreeDetailResultDto;
import com.example.dw.domain.dto.admin.AdminQnaBoardList;
import com.example.dw.domain.dto.admin.AdminQnaDetailResultDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminCommunityRepositoryCustom {


    //qna게시판 리스트
    Page<AdminQnaBoardList> qnaBoardList(Pageable pageable, SearchForm searchForm);

    //자유게시판리스트
    Page<AdminFreeBoardList> freeBoardList(Pageable pageable, SearchForm searchForm);

    
    //qna상세
    AdminQnaDetailResultDto qnaDetail(Long qnaId);

    //자유게시판 상세

    AdminFreeDetailResultDto freeBoardDetail(Long freeBoardId);

}
