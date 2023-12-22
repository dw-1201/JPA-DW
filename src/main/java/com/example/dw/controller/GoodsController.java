package com.example.dw.controller;

import com.example.dw.repository.goods.ShopRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shop/*")
public class GoodsController {

    private final ShopRepositoryCustom shopRepositoryCustom;

    /**
     * 쇼핑 리스트 페이지
     */
    @GetMapping("/shopList")
    public String shopList(){
        return "/shopping/shop";
    }
    @GetMapping("/shopList-a")
    public String shopLista(){
        return "/shopping/shop-a";
    }
    @GetMapping("/shopList-b")
    public String shopListb(){
        return "/shopping/shop-b";
    }
    @GetMapping("/shopList-c")
    public String shopListc(){
        return "/shopping/shop-c";
    }
    @GetMapping("/shopList-d")
    public String shopListd(){
        return "/shopping/shop-d";
    }
    @GetMapping("/shopList-e")
    public String shopListe(){
        return "/shopping/shop-e";
    }
    @GetMapping("/shopList-f")
    public String shopListf(){
        return "/shopping/shop-f";
    }

    /**
     * 쇼핑 상세 페이지
     */
    @GetMapping("/shopDetail/{id}")
    public String shopDetail(@PathVariable("id") Long id, Model model){

        model.addAttribute("id", id);

        return "/shopping/shopDetail";
    }

//    @GetMapping("/shopDetail/{goodsId}")
//    public String shopDetail(@PathVariable("goodsId") Long goodsId, Model model){
//
//        List<GoodsDetailDto> result =
//                shopRepositoryCustom.findGoodsById(goodsId);
//
//        System.out.println("[상품 상세 정보] : "+result.toString());
//        model.addAttribute("goods", result.get(0));
//
//        return "/shopping/shopDetail";
//    }

    /**
     * 쇼핑 카트 페이지
     */
    @GetMapping("/shopCart")
    public String shopCart(){
        return "/shopping/shopCart";
    }
    /**
     * 쇼핑 추가정보 페이지
     */
    @GetMapping("/shopAddInfo")
    public String shopAddInfo(){
        return "/shopping/shopAddInfo";
    }
    /**
     * 쇼핑 결제 페이지
     */
    @GetMapping("/shopPay")
    public String shopPay(){
        return "/shopping/shopPay";
    }
    /**
     * 쇼핑 Q and A 페이지
     */
    @GetMapping("/shopQandA")
    public String shopQandA(){
        return "/shopping/shopQandA";
    }
    /**
     * 쇼핑 리뷰 페이지
     */
    @GetMapping("/shopReview")
    public String shopReview(){
        return "/shopping/shopReview";
    }
}
