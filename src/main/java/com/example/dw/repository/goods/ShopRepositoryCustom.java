package com.example.dw.repository.goods;

import com.example.dw.domain.dto.goods.*;
import com.example.dw.domain.form.SearchForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ShopRepositoryCustom {

    // 쇼핑 페이지 전체 리스트, 페이징, 검색
    Page<GoodsListDto> findGoodsListAll(Pageable pageable, SearchForm searchForm);
    //간식
    Page<GoodsListDto> findGoodsAList(Pageable pageable, SearchForm searchForm);
    //영양제
    Page<GoodsListDto> findGoodsBList(Pageable pageable, SearchForm searchForm);
    //위생용품
    Page<GoodsListDto> findGoodsCList(Pageable pageable, SearchForm searchForm);
    //이동장
    Page<GoodsListDto> findGoodsDList(Pageable pageable, SearchForm searchForm);
    //장난감
    Page<GoodsListDto> findGoodsEList(Pageable pageable, SearchForm searchForm);
    //산책용품
    Page<GoodsListDto> findGoodsFList(Pageable pageable, SearchForm searchForm);

    Optional<GoodsDetailDto> findGoodsById(Long id);

    Optional<GoodsAddInfoDto> findGoodsAddInfoById(Long id);

    List<GoodsReviewListDto> findGoodsReviewById(Long id);

    List<GoodsQueDto> findGoodsQueId(Long id);

    List<GoodsDetailImgDto> findGoodsDetailImg(Long goodsId);

    CartDto findCartIdByUserId(Long userId);

    boolean checkGoodsId(Long goodsId, Long userId, Long cartId);

    List<GoodsCartItemDto> findGoodsCartItemById(Long cartId, Long userId);

    //쇼핑 카테고리별 리스트 ( 일딴
//    List<GoodsByCateDto> shopListByCategory(String cate);




}
