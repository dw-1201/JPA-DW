package com.example.dw.domain.entity.goods;

import com.example.dw.domain.entity.user.Users;
import com.example.dw.domain.form.GoodsQueReplyForm;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="goods_que_id")
    private GoodsQue goodsQue;

    private String queReplyContent;

    @CreatedDate
    private LocalDateTime queReplyRegisterDate;
    @LastModifiedDate
    private LocalDateTime queReplyModifyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    @Builder
    public GoodsQueReply(Long id, GoodsQue goodsQue, String queReplyContent, LocalDateTime queReplyRegisterDate, LocalDateTime queReplyModifyDate, Users users) {
        this.id = id;
        this.goodsQue = goodsQue;
        this.queReplyContent = queReplyContent;
        this.queReplyRegisterDate = queReplyRegisterDate;
        this.queReplyModifyDate = queReplyModifyDate;
        this.users = users;
    }

    public GoodsQueReply update(GoodsQueReplyForm goodsQueReplyForm){
        this.queReplyContent=goodsQueReplyForm.getQnaReplyContent();
        this.queReplyModifyDate=LocalDateTime.now();
        return this;
    }


}
