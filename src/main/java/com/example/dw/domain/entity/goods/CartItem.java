package com.example.dw.domain.entity.goods;

import com.example.dw.domain.form.CartItemForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Builder
    public CartItem(Long id, Integer cartItemQuantity, Cart cart, Goods goods) {
        this.id = id;
        this.cartItemQuantity = cartItemQuantity;
        this.cart = cart;
        this.goods = goods;
    }

    public CartItem itemCount(CartItemForm cartItemForm){
        this.cartItemQuantity = this.cartItemQuantity+cartItemForm.getCartItemQuantity();
        return this;
    }

    public CartItem(Long id, Cart cart, Goods goods) {
        this.id = id;
        this.cart = cart;
        this.goods = goods;
    }
}
