package com.example.dw.repository.admin;

import com.example.dw.domain.dto.admin.AdminOrderListResultDto;
import com.example.dw.domain.form.AdminSearchOrderForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminOrderRepositoryCustom {



    Page<AdminOrderListResultDto> orderList(Pageable pageable, AdminSearchOrderForm adminSearchOrderForm);


}
