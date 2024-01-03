package com.example.dw.domain.dto.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemCheckDto {

        private Long id;
        private Long goodsId;
        private Long cartId;
        private Long userId;

        @QueryProjection
        public CartItemCheckDto(Long id, Long goodsId, Long cartId, Long userId) {
        this.id = id;
        this.goodsId = goodsId;
        this.cartId = cartId;
        this.userId = userId;
    }
}
