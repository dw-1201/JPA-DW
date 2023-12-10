package com.example.dw.api;

import com.example.dw.domain.dto.admin.GoodsDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goodsr/*")
public class GoodsApiController {


    private final GoodsRepositoryCustom goodsRepositoryCustom;

    @GetMapping("/goodsList/{page}")
    public Page<GoodsDto> findGoodsList(
            @PathVariable("page") int page, SearchForm searchForm){

        Pageable pageable = PageRequest.of(page, 15);
        Page<GoodsDto> result = goodsRepositoryCustom.findGoodsAll(pageable, searchForm);
        return result;

    }



}
