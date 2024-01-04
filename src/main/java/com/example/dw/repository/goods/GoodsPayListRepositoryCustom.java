package com.example.dw.repository.goods;

import com.example.dw.domain.dto.goods.GoodsPickListDto;

import java.util.List;

public interface GoodsPayListRepositoryCustom {

    //결제 페이지 주무 내역 조회
    List<GoodsPickListDto> findGoodPayListIdByUserId(Long userId);
}
