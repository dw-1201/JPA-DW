package com.example.dw.service;

import com.example.dw.domain.form.GoodsCategoryForm;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.goods.GoodsCategory;
import com.example.dw.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoodsService {



    private final GoodsRepository goodsRepository;





    //상품 기본 정보 등록
    public Long register(GoodsForm goodsForm, GoodsCategoryForm goodsCategoryForm) throws IOException {
        GoodsCategory goodsCategory = goodsCategoryForm.toEntity();
        goodsForm.setGoodsCategory(goodsCategory);

        Goods goods = goodsRepository.save(goodsForm.toEntity());

        return goods.getId();
    }



}
