package com.example.dw.domain.entity.goods;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name="goods_que_reply")
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsQueReply {
    @Id
    @GeneratedValue @Column(name="goods_que_reply_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="goods_que_id")
    private GoodsQue goodsQue;


    private String queReplyContent;

    @CreatedDate
    private String queReplyRegisterDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    @LastModifiedDate
    private String queReplyModifyDate;


    @Builder
    public GoodsQueReply(Long id, GoodsQue goodsQue, String queReplyContent, String queReplyRegisterDate, String queReplyModifyDate) {
        this.id = id;
        this.goodsQue = goodsQue;
        this.queReplyContent = queReplyContent;
        this.queReplyRegisterDate = queReplyRegisterDate;
        this.queReplyModifyDate = queReplyModifyDate;
    }
}
