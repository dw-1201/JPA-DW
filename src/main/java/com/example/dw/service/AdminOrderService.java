package com.example.dw.service;

import com.example.dw.domain.dto.admin.AdminOrderDetailResultDto;
import com.example.dw.domain.dto.admin.AdminOrderListResultDto;
import com.example.dw.domain.dto.admin.AdminWeeklyOrderState;
import com.example.dw.domain.dto.admin.GoodsSaleByCategory;
import com.example.dw.domain.form.AdminSearchOrderForm;
import com.example.dw.repository.admin.AdminOrderRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminOrderService {


    private final AdminOrderRepositoryCustom adminOrderRepositoryCustom;


    //관리자 페이지 일별 주문현황
    @Transactional
    public List<AdminWeeklyOrderState> weeklyOrderStateList(){

        return adminOrderRepositoryCustom.weeklyOrderState();

    }

    //상품 카테고리별 판매 비율
    @Transactional
    public List<GoodsSaleByCategory> saleByCategory(){

        return adminOrderRepositoryCustom.saleByCategory();
    }


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
