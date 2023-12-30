package com.example.dw.domain.entity.goods;

import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "cart")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name="user_id")
    private Users users;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<CartItem> cartItems = new ArrayList<>();

    @Builder
    public Cart(Long id, Users users, List<CartItem> cartItems) {
        this.id = id;
        this.users = users;
        this.cartItems = cartItems;
    }
}
