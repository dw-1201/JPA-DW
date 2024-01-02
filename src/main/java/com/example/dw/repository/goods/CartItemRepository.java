package com.example.dw.repository.goods;

import com.example.dw.domain.entity.goods.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

    Long findCartItemById(Long cartItemId);

    CartItem findByCartIdAndGoodsId(Long cartId, Long goodsId);
    void deleteByGoodsId(Long goodsId);

}
