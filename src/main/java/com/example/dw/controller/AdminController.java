package com.example.dw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class AdminController {




    @GetMapping("/FBList")
    public String FreeBoardList(){
        return "/admin/adminFreeList";
    }

    @GetMapping("/goodsList")
    public String GoodsList(){
        return "/admin/adminGoodsList";
    }

    @GetMapping("/goodsReg")
    public String goodsRegister(){
        return "/admin/adminGoodsReg";
    }



}
