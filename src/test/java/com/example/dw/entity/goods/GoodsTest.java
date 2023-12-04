//package com.example.dw.entity.goods;
//
//import com.example.dw.entity.user.*;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Commit;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//@Commit
//class GoodsTest {
//
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @BeforeEach
//    void before(){
//        Goods goods = new Goods();
//        Goods goods2 = new Goods();
//
//        GoodsCategory goodsCategory = new GoodsCategory();
//        GoodsDetailImg goodsDetailImg = new GoodsDetailImg();
//        GoodsDetailImg goodsDetailImg2 = new GoodsDetailImg();
//
//        GoodsMainImg goodsMainImg = new GoodsMainImg();
//        GoodsMainImg goodsMainImg2 = new GoodsMainImg();
//
//
//
//        goodsCategory.setGoodsCategoryName("ㅑㅑㅑㅑㅑ");
//        em.persist(goodsCategory);
//
//        goods.setGoodsCategory(goodsCategory);
//        goods.setGoodsName("아아아");
//        goods.setGoodsMade("123");
//        goods.setGoodsCertify("123");
//        goods.setGoodsPrice(123L);
//        goods.setGoodsQuantity(123L);
//        goods.setGoodsDetailContent("123");
//
//
//        goodsMainImg.setGoodsMainImgName("123");
//        goodsMainImg.setGoodsMainImgPath("123");
//        goodsMainImg.setGoodsMainImgUuid("!23");
//        goodsMainImg.setGoods(goods);
//        em.persist(goodsMainImg);
//
//        goodsDetailImg.setGoodsDetailImgName("123");
//        goodsDetailImg.setGoodsDetailImgPath("123");
//        goodsDetailImg.setGoodsDetailImgUuid("!23");
//        goodsDetailImg.setGoods(goods);
//        em.persist(goodsDetailImg);
//
//        em.persist(goods);
//
//
//
//
//
//        ///////////
//        goods2.setGoodsCategory(goodsCategory);
//        goods2.setGoodsName("아아아");
//        goods2.setGoodsMade("123");
//        goods2.setGoodsCertify("123");
//        goods2.setGoodsPrice(123L);
//        goods2.setGoodsQuantity(123L);
//        goods2.setGoodsDetailContent("123");
//
//
//        goodsMainImg2.setGoodsMainImgName("123");
//        goodsMainImg2.setGoodsMainImgPath("123");
//        goodsMainImg2.setGoodsMainImgUuid("!23");
//        goodsMainImg2.setGoods(goods2);
//        em.persist(goodsMainImg2);
//
//        goodsDetailImg2.setGoodsDetailImgName("123");
//        goodsDetailImg2.setGoodsDetailImgPath("123");
//        goodsDetailImg2.setGoodsDetailImgUuid("!23");
//        goodsDetailImg2.setGoods(goods2);
//        em.persist(goodsDetailImg2);
//
//        em.persist(goods2);
//
//
//
//
//        Users users = new Users();
////        Address address = new Address();
//        Pet pet = new Pet();
//        PetImg petImg = new PetImg();
//        UserFile userFile = new UserFile();
//        PetCategory petCategory = new PetCategory();
//
//
//        userFile.setName("iii");
//        userFile.setRoute("uuu");
//        userFile.setUuid("qqqq");
//
////
////        address.setZipCode("123");
////        address.setAddress("123");
////        address.setDetail("123");
//
//        users.setUserName("name");
//        users.setUserPassword("1234");
//        users.setUserPhone("01012341234");
//        users.setUserEmail("123@naver.cpm");
//        users.setUserIntroduction("1111");
//        users.setUserNickName("1234");
//        users.setUserJoinDate(LocalDateTime.now());
////        users.setAddress(address);
//        userFile.setUsers(users);
//        em.persist(users);
//        em.persist(userFile);
//
//        petCategory.setCategoryName("얌야먀얌");
//        em.persist(petCategory);
//
//        pet.setPetCategory(petCategory);
//        pet.setPetGender("Y");
//        pet.setName("dd");
//        pet.setBirthDate("2022");
////        pet.setNeutering("y");
//        pet.setWeight(59L);
//        pet.setUsers(users);
//        em.persist(pet);
//
//        petImg.setPetUuid("ddd");
//        petImg.setPetPath("oooo");
//        petImg.setPetFileName("3333");
//        pet.setPetImg(petImg);
//        petImg.setPet(pet);
//        em.persist(petImg);
//
//    }
//
//
//    @Test
//    void cartTest(){
//
//        Cart cart = new Cart();
//
//        CartItem cartItem = new CartItem();
//        CartItem cartItem2 = new CartItem();
//
//
//        Users findUser = em.find(Users.class, 1L);
//
//
//        Goods findGoods = em.find(Goods.class, 1L);
//        Goods findGoods2 = em.find(Goods.class, 2L);
//
//
//
//
//        cart.setUsers(findUser);
//        em.persist(cart);
//
//        cartItem.setCart(cart);
//        cartItem.setCartItemQuantity(30);
//        cartItem.setGoods(findGoods);
//
//        em.persist(cartItem);
//
//
//
//
//
//
//        cartItem2.setCart(cart);
//        cartItem2.setCartItemQuantity(45);
//        cartItem2.setGoods(findGoods2);
//
//        em.persist(cartItem2);
//
//
//
//
//
//
//
//
//
//    }
//    @Test
//    void queTest(){
//
//        Users findUser = em.find(Users.class, 1L);
//
//        Goods findGoods = em.find(Goods.class, 1L);
//
//        GoodsQue goodsQue = new GoodsQue();
//        GoodsQue goodsQue2 = new GoodsQue();
//        GoodsQueReply goodsQueReply = new GoodsQueReply();
//        GoodsQueReply goodsQueReply2 = new GoodsQueReply();
//
//        goodsQue.setGoods(findGoods);
//        goodsQue.setUsers(findUser);
//        goodsQue.setQueContent("야미");
//
//        goodsQue2.setUsers(findUser);
//        goodsQue2.setGoods(findGoods);
//        goodsQue2.setQueContent("야야야미");
//
//        em.persist(goodsQue);
//        em.persist(goodsQue2);
//
//
//        /////////=======================
//
//        goodsQueReply.setGoodsQue(goodsQue);
//        goodsQueReply.setQueReplyContent("답변완룡!");
//        em.persist(goodsQueReply);
//
//        goodsQueReply2.setGoodsQue(goodsQue2);
//        goodsQueReply2.setQueReplyContent("두번쨰 답변완룡!");
//
//        em.persist(goodsQueReply2);
//
//    }
//}