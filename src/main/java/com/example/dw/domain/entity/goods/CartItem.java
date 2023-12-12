package com.example.dw.domain.entity.goods;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Table(name = "cart_item")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItem {

    @Id @GeneratedValue
    @Column(name="cart_item_id")
    private Long id;
    private Integer cartItemQuantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private Goods goods;



//   //장바구니 아이템 생성//
//
//    public static CartItem createCartItem(Goods goods,int cartItemQuantity){
//        CartItem cartItem = new CartItem();
//        cartItem.setGoods(goods);
//        cartItem.setCartItemQuantity(cartItemQuantity);
//
//        return cartItem;
//    }





}
