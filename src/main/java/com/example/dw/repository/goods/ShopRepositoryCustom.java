package com.example.dw.repository.goods;

import com.example.dw.domain.dto.goods.GoodsDetailDto;
import com.example.dw.domain.dto.goods.GoodsListDto;
import com.example.dw.domain.dto.goods.GoodsQueDto;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShopRepositoryCustom {

    Page<GoodsListDto> findGoodsListAll(Pageable pageable, SearchForm searchForm);

    List<GoodsDetailDto> findGoodsById(Long id);

    List<GoodsQueDto> findGoodsQueId(Long id);
}
