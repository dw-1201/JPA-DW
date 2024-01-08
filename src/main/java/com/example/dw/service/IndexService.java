package com.example.dw.service;

import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
import com.example.dw.domain.dto.goods.RecentViewGoodsDto;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class IndexService {

    private final GoodsRepositoryCustom goodsRepositoryCustom;
    private final ShopRepositoryCustom shopRepositoryCustom;

    @Transactional
    public List<IndexGoodsByCateDto> indexGoodsByCategory(String cate){

        return goodsRepositoryCustom.indexGoodsListByCategory(cate);
    }

    //최근 본 상품
    @Transactional
    public List<RecentViewGoodsDto> recentViewGoods(HttpSession session){


        try{
            return shopRepositoryCustom.recentViewGoods(session);

        }catch (NullPointerException e){
            e.printStackTrace();
            return null;
        }
    }
}
