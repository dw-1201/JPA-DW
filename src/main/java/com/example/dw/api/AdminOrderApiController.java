package com.example.dw.api;

import com.example.dw.domain.dto.admin.AdminOrderDetailResultDto;
import com.example.dw.domain.dto.admin.AdminOrderListResultDto;
import com.example.dw.domain.form.AdminSearchOrderForm;
import com.example.dw.service.AdminOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admins")
public class AdminOrderApiController {




    private final AdminOrderService adminOrderService;


    //관리자 페이지 주문 리스트
    @GetMapping("/orderList/{page}")
    public Page<AdminOrderListResultDto> orderList(@PathVariable("page")int page,
                                                   AdminSearchOrderForm adminSearchOrderForm){

        Pageable pageable = PageRequest.of(page, 15);

        System.out.println(adminSearchOrderForm+"@@@@@@@@@@@");
        return  adminOrderService.orderList(pageable, adminSearchOrderForm);

    }

    
    //통신확인용
    //관리자 페이지 주문 상세
    @GetMapping("/orderDetail/{userId}/{orderId}")
    public AdminOrderDetailResultDto orderDetail(@PathVariable("userId")Long userId, @PathVariable("orderId") Long orderId){
        return adminOrderService.orderDetail(userId, orderId);
    }
}
