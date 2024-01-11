package com.example.dw.service;

import com.example.dw.domain.entity.goods.Cart;
import com.example.dw.domain.entity.order.Orders;
import com.example.dw.domain.form.*;
import com.example.dw.repository.goods.CartItemRepository;
import com.example.dw.repository.goods.CartRepository;
import com.example.dw.repository.order.OrderItemRepository;
import com.example.dw.repository.order.OrderListRepository;
import com.example.dw.repository.order.OrderRepository;
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

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderListRepository orderListRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private Object Optional;

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
            Cart cartId = cartRepository.findCartIdByUsersId(userId);

            List<GoodsPayListFrom> goodsPayListDtoList = (List<GoodsPayListFrom>)httpSession.getAttribute("goodsPayList");
            for(GoodsPayListFrom goodsPayListFrom : goodsPayListDtoList)
            {
                goodsPayListFrom.setOrderId(orderId);
                //주문 상품 저장
                orderItemRepository.save(goodsPayListFrom.toEntity());
                cartItemRepository.deleteByCartId(cartId.getId());
            }

            OrderListForm orderListForm = new OrderListForm();
            orderListForm.setOrderId(orderId);
            orderListRepository.save(orderListForm.toEntity());

            //주문 상품 삭제
            httpSession.removeAttribute("goodsPayList");
            System.out.println("카트 삭제 완료");


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("33333333333333333333");
    }


    //주문서 단건 작성
//    @Transactional
//    public void registerSingle(OrderForm orderForm, HttpSession httpSession) throws IOException {
//
//        Long userId = (Long)httpSession.getAttribute("userId");
//        orderForm.setUserId(userId);
//
//        System.out.println("1111111111111111111111");
//        try {
//            Orders order = orderRepository.save(orderForm.toEntity());
//            System.out.println(orderForm+"2222222222222222222");
//
//            Long orderId = order.getId();
//
//            List<GoodsPaySingleFrom> goodsPaySingleDto = (List<GoodsPaySingleFrom>)httpSession.getAttribute("goodsPayList");
//
//            if (goodsPaySingleDto != null) {
//                for(GoodsPaySingleFrom goodsPaySingleFrom : goodsPaySingleDto)
//                {
//                    goodsPaySingleFrom.setOrderId(orderId);
//                    //주문 상품 저장
//                    orderItemRepository.save(goodsPaySingleFrom.toEntity());
//
//                    OrderListForm orderListForm = new OrderListForm();
//                    orderListForm.setOrderId(orderId);
//                    orderListRepository.save(orderListForm.toEntity());
//                }
//            }
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("33333333333333333333");
//    }


    //주문서 작성
    @Transactional
    public void registerSingle(OrderForm orderForm, HttpSession httpSession) throws IOException {

        Long userId = (Long)httpSession.getAttribute("userId");
        orderForm.setUserId(userId);
        System.out.println("1111111111111111111111");

        try {
            Orders order = orderRepository.save(orderForm.toEntity());
            System.out.println(orderForm+"2222222222222222222");

            Long orderId = order.getId();

            List<GoodsPaySingleFrom> goodsPaySingleDto = (List<GoodsPaySingleFrom>)httpSession.getAttribute("goodsPaySingle");
            for(GoodsPaySingleFrom goodsPaySingleFrom : goodsPaySingleDto)
            {
                goodsPaySingleFrom.setOrderId(orderId);
                //주문 상품 저장
                orderItemRepository.save(goodsPaySingleFrom.toEntity());
                System.out.println(goodsPaySingleFrom.toEntity() +"@@@@@@@@@@@@@goodsPaySingleFrom@@@@@@@@@@2");
            }

            System.out.println(goodsPaySingleDto+"goodsPaySingleDto aeniaowefaef");
            OrderListForm orderListForm = new OrderListForm();
            orderListForm.setOrderId(orderId);
            orderListRepository.save(orderListForm.toEntity());
            System.out.println(orderListForm.toEntity() +"@@@@@@@@@@@@@orderListForm@@@@@@@@@@2");


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("33333333333333333333");
    }

}
