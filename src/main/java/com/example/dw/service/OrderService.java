package com.example.dw.service;

import com.example.dw.domain.form.GoodsPayListFrom;
import com.example.dw.domain.entity.order.Orders;
import com.example.dw.domain.form.OrderForm;
import com.example.dw.domain.form.OrderListForm;
import com.example.dw.repository.order.OrderItemRepository;
import com.example.dw.repository.order.OrderListRepository;
import com.example.dw.repository.order.OrderRepository;
import com.example.dw.repository.user.UsersRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final HttpSession httpSession;
    private final UsersRepository usersRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderListRepository orderListRepository;

    //주문서 작성
    @Transactional
    public void register(OrderForm orderForm, HttpSession httpSession) throws IOException {

        Long userId = (Long)httpSession.getAttribute("userId");
        orderForm.setUserId(userId);
        System.out.println("1111111111111111111111");
        try {
            Orders order = orderRepository.save(orderForm.toEntity());
            System.out.println(orderForm+"2222222222222222222");

            Long orderId = order.getId();

            List<GoodsPayListFrom> goodsPayListDtoList = (List<GoodsPayListFrom>)httpSession.getAttribute("goodsPayList");
            for(GoodsPayListFrom goodsPayListFrom : goodsPayListDtoList)
            {
                goodsPayListFrom.setOrderId(orderId);
                orderItemRepository.save(goodsPayListFrom.toEntity());



            }


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("33333333333333333333");
    }

    @Transactional
    public void registerList(OrderListForm orderListForm) throws IOException{
        try{
            orderListRepository.save(orderListForm.toEntity());
            System.out.println("OrderListForm save");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("OrderListForm no save");
    }
}
