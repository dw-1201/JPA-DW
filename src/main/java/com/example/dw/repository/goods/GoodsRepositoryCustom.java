package com.example.dw.repository.goods;

import com.example.dw.domain.dto.admin.AdminGoodsDetailResultDto;
import com.example.dw.domain.dto.admin.AdminGoodsDto;
import com.example.dw.domain.dto.admin.UserFileImgDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GoodsRepositoryCustom {

    Page<AdminGoodsDto> findGoodsAll(Pageable pageable, SearchForm searchForm);

    List<AdminGoodsDetailResultDto> findGoodsById(Long id);

}