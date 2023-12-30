package com.example.dw.domain.entity.goods;

import com.example.dw.domain.entity.user.Users;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

    @Builder
    public Cart(Long id, Users users) {
        this.id = id;
        this.users = users;
    }
}
