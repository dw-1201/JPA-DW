package com.example.dw.api;

import com.example.dw.domain.dto.admin.GoodsDto;
import com.example.dw.domain.dto.goods.GoodsDetailResultDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.goods.GoodsRepository;
import com.example.dw.repository.goods.GoodsRepositoryCustom;
import com.example.dw.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goodsr/*")
public class GoodsApiController {

    private final GoodsService goodsService;
    private final GoodsRepositoryCustom goodsRepositoryCustom;
    private final GoodsRepository goodsRepository;

    @GetMapping("/goodsList/{page}")
    public Page<GoodsDto> findGoodsList(
            @PathVariable("page") int page,
            SearchForm searchForm
    ){
        Pageable pageable = PageRequest.of(page, 15);

        Page<GoodsDto> result = goodsRepositoryCustom.findGoodsAll(pageable, searchForm);

       result.stream().forEach(r->
               System.out.println(r.getId()+"============="));

        return result;
    }
    //상품 상세 페이지 이동
    @GetMapping("/detail/{goodsId}")
    public Optional<GoodsDetailResultDto> goodsDetail(@PathVariable("goodsId") Long goodsId){

        Optional<GoodsDetailResultDto> result =
                goodsRepositoryCustom.findGoodsById(goodsId).stream().findAny();


        System.out.println("[상품 상세 정보] : "+result.toString());
        return result;

    }


}
