package com.example.dw.domain.dto.goods;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ShopCartListDto {


    private Long cartId;
    private Long userId;
    private List<CartItemDetails> cartItemDetails;


    public ShopCartListDto(Long cartId, Long userId) {
        this.cartId = cartId;
        this.userId = userId;
    }

    public ShopCartListDto(Long cartId, Long userId, List<CartItemDetails> cartItemDetails) {
        this.cartId = cartId;
        this.userId = userId;
        this.cartItemDetails = cartItemDetails;
    }
}
