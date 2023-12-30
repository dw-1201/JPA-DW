package com.example.dw.controller;

import com.example.dw.domain.dto.goods.GoodsDetailDto;
import com.example.dw.repository.goods.GoodsRepository;
import com.example.dw.repository.goods.ShopRepositoryCustom;
import com.example.dw.service.GoodsService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shop/*")
public class GoodsController {

    private final ShopRepositoryCustom shopRepositoryCustom;
    private final HttpSession httpSession;
    private final GoodsService goodsService;
    private final GoodsRepository goodsRepository;

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

     Optional<GoodsDetailDto> detail =  goodsService.goodsDetail(id);

     detail.ifPresent(details -> model.addAttribute("detail", details));

        System.out.println(detail.toString());

     return "/shopping/shopDetail";
    }
    /**
     * 쇼핑 추가정보 페이지
     */
//    @GetMapping("/shopAddInfo")
//    public String shopAddInfo(){
//        return "/shopping/shopAddInfo";
//    }
    /**
     * 쇼핑 리뷰 페이지
     */
    @GetMapping("/shopReview/{id}")
    public String shopReview(@PathVariable("id") Long id, Model model){
        model.addAttribute("id", id);
        return "/shopping/shopReview";
    }

    /**
     * 쇼핑 Q and A 문의 글 작성 페이지
     */


    /**
     * 쇼핑 카트 페이지
     */
//    @GetMapping("/shopCart/{userId}")
//    public String shopCart(@PathVariable("userId") Long userId, Model model) {
//
//        CartForm cartForm = new CartForm();
//        cartForm.setUserId(userId);
//
//        try {
//            Long cartId = shopRepositoryCustom.findCartIdByUserId(userId).getId();
//            return "/shopping/shopCart";
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//
//            goodsService.cartRegister(cartForm);
//            return "/shopping/shopCart";
//        }
//    }

    /**
     * 쇼핑 결제 페이지
     */
    @GetMapping("/shopPay")
    public String shopPay(){
        return "/shopping/shopPay";
    }



}
