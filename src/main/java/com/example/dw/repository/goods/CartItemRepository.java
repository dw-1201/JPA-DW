package com.example.dw.repository.goods;

import com.example.dw.domain.entity.goods.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

    Long findCartItemById(Long cartItemId);

    CartItem findByCartIdAndGoodsId(Long cartId, Long goodsId);

    void deleteByGoodsId(Long goodsId);

    void deleteByCartId(Long cartId);


//    @Query("select ci from CartItem ci LEFT join ci.cart c left join ci.goods g where ci.cart.id = :cartId and ci.goods.id = :goodsId")
//    Optional<CartItem> findByCartItemById(@Param("cartId") Long cartId, @Param("goodsId")Long goodsId);

//    void deleteByCartIdAndGoodsId(@Param("cartId") Long cartId, @Param("goodsId")Long goodsId);

//    void deleteByCartItemId(Long cartItemId);
}
