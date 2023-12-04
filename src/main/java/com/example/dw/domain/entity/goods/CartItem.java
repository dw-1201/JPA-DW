package com.example.dw.domain.entity.goods;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "cart_item")
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
