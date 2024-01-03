package com.example.dw.api;

import com.example.dw.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders/*")
public class OrderApiController {

    private final OrderService orderService;

    /**
     * 결제 페이지
     */
    @GetMapping("/orderList/{userId}")
    public void orderList(){

    }
}
