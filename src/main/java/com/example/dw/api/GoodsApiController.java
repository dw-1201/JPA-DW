package com.example.dw.api;

import com.example.dw.domain.dto.goods.GoodsDetailDto;
import com.example.dw.domain.dto.goods.GoodsListDto;
import com.example.dw.domain.form.SearchForm;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops/*")
public class GoodsApiController {

    private final ShopRepositoryCustom shopRepositoryCustom;

    /**
     * 쇼핑 리스트 페이지
     */
    @GetMapping("/shopList/{page}")
    public Page<GoodsListDto> findShopList(
            @PathVariable("page") int page, SearchForm searchForm){

        Pageable pageable = PageRequest.of(page,12);
        Page<GoodsListDto> result = shopRepositoryCustom.findGoodsListAll(pageable, searchForm);
        System.out.println(result.toString()+"############");
        return result;
    }
    /**
     * 쇼핑 상세 페이지
     * @return
     */
    @GetMapping("/shopDetail/{goodsId}")
    public List<GoodsDetailDto> shopDetail(@PathVariable("goodsId") Long goodsId, Model model){

        if (goodsId == null) {
            throw new IllegalArgumentException("존재하지 않는 게시물 번호");
        }

        List<GoodsDetailDto> result =
                shopRepositoryCustom.findGoodsById(goodsId);

        System.out.println("[상품 상세 정보] : "+result.toString());
        model.addAttribute("goods", result.get(0));

//        return "/shopping/shopDetail";
        return result;
    }
    /**
     * 쇼핑 이미지 처리
     */
    @Value("${file.dir}")
    private String fileShopImg;

    @GetMapping("/shopImg")
    public byte[] getEmpImg(String fileFullPath) throws IOException {
        return FileCopyUtils.copyToByteArray(new File(fileShopImg, fileFullPath));
    }

}
