package com.example.dw.service;

import com.example.dw.entity.dto.GoodsCategoryForm;
import com.example.dw.entity.dto.GoodsDetailImgForm;
import com.example.dw.entity.dto.GoodsForm;
import com.example.dw.entity.dto.GoodsMainImgForm;
import com.example.dw.entity.goods.Goods;
import com.example.dw.entity.goods.GoodsCategory;
import com.example.dw.entity.goods.GoodsDetailImg;
import com.example.dw.entity.goods.GoodsMainImg;
import com.example.dw.repository.GoodsCategoryRepository;
import com.example.dw.repository.GoodsMainImgRepository;
import com.example.dw.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
