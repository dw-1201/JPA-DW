package com.example.dw.entity.goods;

import com.example.dw.entity.user.Users;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder.Default;

import java.time.LocalDateTime;

@Entity
@Table(name="goods_que")
@Getter
public class GoodsQue {
    @Id
    @GeneratedValue
    @Column(name="goods_que_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="goods_id")
    private Goods goods;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "goodsQue")
    private GoodsQueReply goodsQueReply;

    private String queContent;

    @Default
    private LocalDateTime queRegisterDate = LocalDateTime.now();
    @Default
    private LocalDateTime queModifyDate = LocalDateTime.now();




}
