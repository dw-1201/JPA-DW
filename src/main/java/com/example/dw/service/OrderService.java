package com.example.dw.service;

import com.example.dw.domain.entity.goods.Cart;
import com.example.dw.domain.entity.order.Orders;
import com.example.dw.domain.form.GoodsPayListFrom;
import com.example.dw.domain.form.OrderForm;
import com.example.dw.domain.form.OrderListForm;
import com.example.dw.repository.goods.CartItemRepository;
import com.example.dw.repository.goods.CartRepository;
import com.example.dw.repository.goods.GoodsRepository;
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
    private final GoodsRepository goodsRepository;

    //주문서 작성
    @Transactional
    public void register(OrderForm orderForm, HttpSession httpSession) throws IOException {

        Long userId = (Long)httpSession.getAttribute("userId");
        orderForm.setUserId(userId);
//        Long cartId = cartRepository.findCartByUsersId(userId);
        System.out.println("1111111111111111111111");
//        System.out.println("카트아뒤"+cartId);
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


                //상품 판매량 업데이트
                goodsRepository.updateSaleCount(Integer.valueOf(goodsPayListFrom.getGoodsQuantity()), Long.valueOf(goodsPayListFrom.getGoodsId()));

            }


            OrderListForm orderListForm = new OrderListForm();
            orderListForm.setOrderId(orderId);
            orderListRepository.save(orderListForm.toEntity());





            //주문 상품 삭제
//            cartRepository.deleteById(cartId.getId());
            httpSession.removeAttribute("goodsPayList");

                System.out.println("카트 삭제 완료");


        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("33333333333333333333");
    }

}
