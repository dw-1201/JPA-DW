package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Cart;
import com.example.dw.domain.entity.goods.CartItem;
import com.example.dw.domain.entity.goods.Goods;
import lombok.Builder;
import lombok.Data;

//장바구니에 상품을 추가하기 윈한 Form
@Data
public class CartItemForm {

    private Long id;
    private Integer cartItemQuantity;
    private Long cartId;
    private Long goodsId;

    @Builder
    public CartItemForm(Long id, Integer cartItemQuantity, Long cartId, Long goodsId) {
        this.id = id;
        this.cartItemQuantity = cartItemQuantity;
        this.cartId = cartId;
        this.goodsId = goodsId;
    }

    public CartItem toEntity(){
        return CartItem.builder()
                .id(id)
                .cartItemQuantity(cartItemQuantity)
                .cart(Cart.builder().id(cartId).build())
                .goods(Goods.builder().id(goodsId).build())
                .build();
    }
}
