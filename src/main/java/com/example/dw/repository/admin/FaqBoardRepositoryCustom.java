package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.FaqBoardDto;
import com.example.dw.domain.entity.admin.FaqBoard;
import com.example.dw.domain.form.SearchFaqForm;

import java.util.List;

public interface FaqBoardRepositoryCustom {

    List<FaqBoardDto> findFaqListBySearch();

}
