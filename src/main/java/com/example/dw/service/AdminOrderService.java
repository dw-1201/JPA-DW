package com.example.dw.service;

import com.example.dw.domain.dto.admin.AdminOrderDetailResultDto;
import com.example.dw.domain.dto.admin.AdminOrderListResultDto;
import com.example.dw.domain.form.AdminSearchOrderForm;
import com.example.dw.repository.admin.AdminOrderRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminOrderService {


    private final AdminOrderRepositoryCustom adminOrderRepositoryCustom;


    //관리자 페이지 주문 리스트
    @Transactional
    public Page<AdminOrderListResultDto> orderList(Pageable pageable, AdminSearchOrderForm adminSearchOrderForm){


        return  adminOrderRepositoryCustom.orderList(pageable, adminSearchOrderForm);


    }


    //관리자 페이지 주문 상세
    @Transactional
    public AdminOrderDetailResultDto orderDetail(Long userId, Long orderId){

        return Optional.ofNullable(adminOrderRepositoryCustom.orderDetail(userId,orderId)).orElseThrow(()->{
            throw new IllegalArgumentException("조회 정보 없음");
        });

    }


}
