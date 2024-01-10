package com.example.dw.service;

import com.example.dw.domain.dto.admin.AdminOrderListResultDto;
import com.example.dw.domain.form.AdminSearchOrderForm;
import com.example.dw.repository.admin.AdminOrderRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminOrderService {


    private final AdminOrderRepositoryCustom adminOrderRepositoryCustom;


    @Transactional
    public Page<AdminOrderListResultDto> orderList(Pageable pageable, AdminSearchOrderForm adminSearchOrderForm){


        return  adminOrderRepositoryCustom.orderList(pageable, adminSearchOrderForm);


    }


}
