package com.example.dw.repository.community;

import com.example.dw.domain.dto.community.QuestionDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionRepositoryCuston {
    Page<QuestionDto> findQnaListBySearch(Pageable pageable, SearchForm searchForm);
//    List<QuestionDto> findQnaListBySearch();
}
