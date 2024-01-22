package com.example.dw.service;

import com.example.dw.domain.dto.community.IndexWalkMateDto;
import com.example.dw.domain.dto.goods.IndexGoodsByCateDto;
import com.example.dw.domain.dto.index.WeeklyFreeBoardList;
import com.example.dw.domain.dto.index.WeeklyQnaListDto;
import com.example.dw.repository.community.WalkingMateRepositoryCustom;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import com.example.dw.repository.index.IndexRepositoryCustom;
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
    private final IndexRepositoryCustom indexRepositoryCustom;
    
    
    
    
   
    //산책글 리스트
    @Transactional
    public List<IndexWalkMateDto> indexWalkMateList(){

        return walkingMateRepositoryCustom.IndexWalkMateList();

    }


    
    //주간 인기글
    //Qna Best3
    @Transactional
    public List<WeeklyQnaListDto> weeklyQnaList(){
        return indexRepositoryCustom.weeklyQnaList();
    }

    //자유게시판 Best5
    @Transactional
    public  List<WeeklyFreeBoardList> weeklyFreeBoardList(){

        return indexRepositoryCustom.weeklyFreeBoardList();
    }



    
    
    //카테고리별 상품 리스트
    @Transactional
    public List<IndexGoodsByCateDto> indexGoodsByCategory(String cate){

        return goodsRepositoryCustom.indexGoodsListByCategory(cate);
    }

}
