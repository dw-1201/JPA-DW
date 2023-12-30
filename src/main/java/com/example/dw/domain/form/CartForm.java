package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Cart;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//장바구니 번호를 받기 위한 Form
@Data
@NoArgsConstructor
public class CartForm {

    private Long id;
    private Long userId;

    @Builder
    public CartForm(Long id, Long userId) {
        this.id = id;
        this.userId = userId;
    }

    public Cart toEntity(){
        return Cart.builder()
                .id(id)
                .users(Users.builder().id(userId).build())
                .build();
    }
}
