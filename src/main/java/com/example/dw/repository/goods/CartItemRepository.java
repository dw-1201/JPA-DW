package com.example.dw.repository.goods;

import com.example.dw.domain.entity.goods.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
    //카트 아이템 생성
    CartItem findByCartIdAndGoodsId(Long cartId, Long goodsId);
    // 카트 단건 삭제
    void deleteByCartId(Long cartId);
    // 카트 전체 삭제
    @Modifying
    @Query("DELETE FROM CartItem")
    void deleteAll();
}
