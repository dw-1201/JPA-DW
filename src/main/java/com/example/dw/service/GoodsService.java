package com.example.dw.service;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.form.GoodsForm;
import com.example.dw.repository.goods.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoodsService {



    private final GoodsRepository goodsRepository;
    private final FileService fileService;


    //상품 기본 정보 등록
    @Transactional
    public Long register(GoodsForm goodsForm) throws IOException {


        Goods goods = goodsRepository.save(goodsForm.toEntity());

        return goods.getId();
    }
    
    //상품 수정
    
    //상품 삭제
    @Transactional
    public void delete(Long goodsId){

        if (goodsId == null) {
            
            throw new IllegalArgumentException("유효하지 않은 번호");
        }

//        goodsRepository.findById(goodsId).stream().forEach(
//                r-> System.out.println(r.getGoodsDetailImg().toString()+"===========")
//        );

        fileService.removeMainImg(goodsId);
        fileService.removeDetailImgs(goodsId);
        goodsRepository.deleteById(goodsId);

    }



}
