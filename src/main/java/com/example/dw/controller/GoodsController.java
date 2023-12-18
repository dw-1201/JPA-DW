package com.example.dw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shopping/*")
public class GoodsController {

    /**
     * 쇼핑 리스트 페이지
     */
    @GetMapping("/shop")
    public String shopList(){
        return "/shopping/shop";
    }
    @GetMapping("/shop-a")
    public String shopLista(){
        return "/shopping/shop-a";
    }
    @GetMapping("/shop-b")
    public String shopListb(){
        return "/shopping/shop-b";
    }
    @GetMapping("/shop-c")
    public String shopListc(){
        return "/shopping/shop-c";
    }
    @GetMapping("/shop-d")
    public String shopListd(){
        return "/shopping/shop-d";
    }
    @GetMapping("/shop-e")
    public String shopListe(){
        return "/shopping/shop-e";
    }
    @GetMapping("/shop-f")
    public String shopListf(){
        return "/shopping/shop-f";
    }

}
