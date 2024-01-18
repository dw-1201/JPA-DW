package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminNoticeBoardDto;
import com.example.dw.domain.dto.notice.NoticeDetailDto;
import com.example.dw.domain.dto.notice.NoticeListDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoticeBoardRepositoryCustom {

    Page<AdminNoticeBoardDto> findNoticeListBySearch(Pageable pageable, SearchForm searchForm);
    //공지사항 리스트
    Page<NoticeListDto> findNoticeBoardListBySearch(Pageable pageable, String keyword);
    //공지사항 상세페이지
    List<NoticeDetailDto> findNoticeById(Long id);
    //공지사항 자주찾는글 top3
    List<NoticeListDto> findNoticeRankListById();

}
