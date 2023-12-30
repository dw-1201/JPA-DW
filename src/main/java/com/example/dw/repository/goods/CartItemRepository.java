package com.example.dw.repository.goods;

import com.example.dw.domain.entity.goods.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

    Long findCartItemById(Long cartItemId);

    //상품 수량 증가
    @Modifying
    @Query("update CartItem set cartItemQuantity = cartItemQuantity + 1 where id = :goodsId")
    void increaseCartItemQuantity(@Param("goodsId") Long goodsId);

   CartItem findByCartIdAndGoodsId(Long cartId, Long goodsId);

}
