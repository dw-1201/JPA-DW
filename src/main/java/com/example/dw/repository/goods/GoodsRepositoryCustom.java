package com.example.dw.repository.goods;

import com.example.dw.domain.dto.admin.*;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface GoodsRepositoryCustom {

    //관리자 상품 리스트
    Page<AdminGoodsDto> findGoodsAll(Pageable pageable, SearchForm searchForm);

    
    //관리자 상품 상세
    List<AdminGoodsDetailResultDto> findGoodsById(Long id);

    //관리자 상품 상세 - 상품 관련 문의사항 리스트
    Page<AdminGoodsQnaListDto> getQnaList(Long goodsId, Pageable pageable, String state);



    //관리자 상품 문의 리스트
    Page<AdminGoodsQnaListDto> getQnaList(Pageable pageable, String qnaState, String cate, String keyword);



    //관리자 상품 문의 상세
    Optional<AdminGoodsQueDetailDto> getQnaDetail(Long qnaId);

    //관리자 상품 문의 답변 가져오기
    AdminGoodsQueReplyDto getReplyList(Long qnaId);



}