package com.example.dw.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminOrderController {




    @GetMapping("/orderStatus")
    public String orderStatus(){
        return "/admin/adminOrderManage";
    }
    @GetMapping("/orderList")
    public String orderList(){
        return "admin/adminOrderList";
    }




}
