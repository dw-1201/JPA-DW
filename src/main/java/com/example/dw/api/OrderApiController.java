package com.example.dw.api;

import com.example.dw.domain.form.OrderForm;
import com.example.dw.domain.form.OrdersItemForm;
import com.example.dw.service.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders/*")
public class OrderApiController {

    private final OrderService orderService;

    /**
     * 결제시 데이터 받아오기
     */
    @PostMapping("/orderList")
    public void orderList(@RequestBody OrderForm orderForm, HttpSession httpSession) throws IOException {
        Long userId = (Long)httpSession.getAttribute("userId");
        orderForm.setUserId(userId);

        System.out.println("4444444444444444444444");
        try {
            orderService.register(orderForm, httpSession);
            System.out.println(orderForm+"@@@@@@@@@@");
            System.out.println("55555555555555555555555");

            orderService.registerItem(OrdersItemForm.builder().build(),httpSession);
//            orderService.registerList(OrderListForm.builder().build());
            System.out.println("OrdersItemForm+OrderListForm = 저장완료");

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("6666666666666666666666666666");
    }
}
