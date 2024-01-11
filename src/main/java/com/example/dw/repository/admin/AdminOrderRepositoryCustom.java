package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminOrderDetailResultDto;
import com.example.dw.domain.dto.admin.AdminOrderListResultDto;
import com.example.dw.domain.form.AdminSearchOrderForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminOrderRepositoryCustom {


    //관리자 페이지 주문 리스트
    Page<AdminOrderListResultDto> orderList(Pageable pageable, AdminSearchOrderForm adminSearchOrderForm);


    //관리자 페이지 주문 상세
    AdminOrderDetailResultDto orderDetail(Long userId, Long orderId);

}
