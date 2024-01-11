package com.example.dw.controller;

import com.example.dw.domain.dto.admin.AdminOrderDetailResultDto;
import com.example.dw.service.AdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminOrderController {


    private final AdminOrderService adminOrderService;


    @GetMapping("/orderStatus")
    public String orderStatus(){
        return "/admin/adminOrderManage";
    }
    @GetMapping("/orderList")
    public String orderList(){
        return "admin/adminOrderList";
    }


    @GetMapping("/orderDetail/{userId}/{orderId}")
    public String orderDetail(
            @PathVariable("userId") Long userId,
            @PathVariable("orderId") Long orderId, Model model){

        AdminOrderDetailResultDto orderDetail = adminOrderService.orderDetail(userId, orderId);

        model.addAttribute("orderDetail", orderDetail);

        return "/admin/adminOrderDetail";

    }




}
