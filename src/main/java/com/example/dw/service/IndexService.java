package com.example.dw.service;

import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IndexService {

    private final GoodsRepositoryCustom goodsRepositoryCustom;


    @Transactional
    public List<IndexGoodsByCateDto> indexGoodsByCategory(String cate){

        return goodsRepositoryCustom.indexGoodsListByCategory(cate);
    }
}
