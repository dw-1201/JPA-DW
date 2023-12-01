package com.example.dw.entity.goods;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="goods_que_reply")
@Getter
@Setter
public class GoodsQueReply {
    @Id
    @GeneratedValue @Column(name="goods_que_reply_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="goods_que_id")
    private GoodsQue goodsQue;

    private String queReplyContent;
    @Default
    private LocalDateTime queReplyRegisterDate = LocalDateTime.now();
    @Default
    private LocalDateTime queReplyModifyDate = LocalDateTime.now();
    @Default
    private Integer state = 0;


}
