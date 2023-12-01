package com.example.dw.entity.goods;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class GoodsTest {


    @PersistenceContext
    private EntityManager em;

    @Test
    void goods(){

        Goods goods = new Goods();
        GoodsCategory goodsCategory = new GoodsCategory();
        GoodsDetailImg goodsDetailImg = new GoodsDetailImg();
        GoodsMainImg goodsMainImg = new GoodsMainImg();

        goodsCategory.setGoodsCategoryName("ㅑㅑㅑㅑㅑ");
        em.persist(goodsCategory);
        goods.setGoodsCategory(goodsCategory);
        goods.setGoodsName("아아아");
        goods.setGoodsMade("123");
        goods.setGoodsCertify("123");
        goods.setGoodsPrice(123L);
        goods.setGoodsQuantity(123L);
        goods.setGoodsDetailContent("123");


        goodsMainImg.setGoodsMainImgName("123");
        goodsMainImg.setGoodsMainImgPath("123");
        goodsMainImg.setGoodsMainImgUuid("!23");
        goodsMainImg.setGoods(goods);
        em.persist(goodsMainImg);

        goodsDetailImg.setGoodsDetailImgName("123");
        goodsDetailImg.setGoodsDetailImgPath("123");
        goodsDetailImg.setGoodsDetailImgUuid("!23");
        goodsDetailImg.setGoods(goods);
        em.persist(goodsDetailImg);

        em.persist(goods);
    }
}