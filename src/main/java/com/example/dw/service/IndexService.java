package com.example.dw.service;

import com.example.dw.domain.dto.community.IndexWalkMateDto;
import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
import com.example.dw.repository.community.WalkingMateRepositoryCustom;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IndexService {

    private final WalkingMateRepositoryCustom walkingMateRepositoryCustom;
    private final GoodsRepositoryCustom goodsRepositoryCustom;
    private final ShopRepositoryCustom shopRepositoryCustom;

    @Transactional
    public List<IndexGoodsByCateDto> indexGoodsByCategory(String cate){

        return goodsRepositoryCustom.indexGoodsListByCategory(cate);
    }

    //산책글 리스트
    @Transactional
    public List<IndexWalkMateDto> indexWalkMateList(){

        return walkingMateRepositoryCustom.IndexWalkMateList();

    }


    //최근 본 상품
//    @Transactional
//    public List<RecentViewGoodsDto> recentViewGoods(HttpSession session){
//
//
//        try{
//            return shopRepositoryCustom.recentViewGoods(session);
//
//        }catch (NullPointerException e){
//            e.printStackTrace();
//            return null;
//        }
//    }
}
