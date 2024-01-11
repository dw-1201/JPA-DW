package com.example.dw.domain.entity.order;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@SpringBootTest
@Transactional
@Commit
class OrdersTest {

    @PersistenceContext
    private EntityManager em;

//    @Test
//    void test1(){
//        Orders order = new Orders();
//        OrderList orderList =new OrderList();
//        OrderReview orderReview =new OrderReview();
//
//
//        order.setOrderAddressDetail("111");
//        order.setOrderAddressNormal("qqq");
//        order.setOrderUserName("aaa");
//        order.setOrderUserAddressNumber("010");
//        order.setOrderUserEmail("test@naver.com");
//        order.setOrderUserPhoneNumber("1111");
//        order.setOrderList(orderList);
//        em.persist(order);
//
//        System.out.println(order);
//
//        orderList.setOrderDate(LocalDateTime.now());
//        em.persist(orderList);
//
//        System.out.println(orderList);
//
//        orderReview.setRating(3);
//        orderReview.setTitle("상품 굿!");
//        orderReview.setContent("dddddd");
//        orderReview.setOrderList(orderList);
//
//        em.persist(orderReview);
//
//
//    }
//
//    @Test
//    void test2(){
//        OrderList orderList =new OrderList();
//        orderList.setOrderDate(LocalDateTime.now());
//        em.persist(orderList);
//
//        System.out.println(orderList);
//
//        OrderReview orderReview =new OrderReview();
//        orderReview.setRating(3);
//        orderReview.setTitle("상품 굿!");
//        orderReview.setContent("dddddd");
//        orderReview.setOrderList(orderList);
//        em.persist(orderReview);
//
//        OrderReviewImg orderReviewImg =new OrderReviewImg();
//        orderReviewImg.setReviewimgFileName("sssss");
//        orderReviewImg.setReviewimgPath("1231341234");
//        orderReviewImg.setReviewimgUuid("11123123sdef123");
//        orderReviewImg.setOrderReview(orderReview);
//
//        em.persist(orderReviewImg);
//
//        GoodsReviewReply goodsReviewReply =new GoodsReviewReply();
//
//        goodsReviewReply.setGoodsReviewReplyContent("fff");
//        goodsReviewReply.setGoodsReviewReplyMD(LocalDateTime.now());
//        goodsReviewReply.setGoodsReviewReplyRD(LocalDateTime.now());
//        goodsReviewReply.setOrderReview(orderReview);
//
//        em.persist(goodsReviewReply);
//
//    }



}