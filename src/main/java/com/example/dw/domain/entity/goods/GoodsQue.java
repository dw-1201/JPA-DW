package com.example.dw.domain.entity.goods;

import com.example.dw.domain.entity.user.Users;
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
import java.util.List;

@Entity
@Table(name="goods_que")
@Getter
@Builder
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsQue {
    @Id
    @GeneratedValue
    @Column(name="goods_que_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private Users users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="goods_id")
    private Goods goods;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goodsQue", orphanRemoval = true)
    private List<GoodsQueReply> goodsQueReply;

    private String queContent;

    @CreatedDate
    private String queRegisterDate;
    @LastModifiedDate
    private String queModifyDate;

    @Builder.Default
    private Integer state = 0;

    @Builder
    public GoodsQue(Long id, Users users, Goods goods, List<GoodsQueReply> goodsQueReply, String queContent, String queRegisterDate, String queModifyDate, Integer state) {
        this.id = id;
        this.users = users;
        this.goods = goods;
        this.goodsQueReply = goodsQueReply;
        this.queContent = queContent;
        this.queRegisterDate = queRegisterDate;
        this.queModifyDate = queModifyDate;
        this.state = state;
    }


    //날짜포맷
    @PrePersist
    public void onPrePersist(){
        this.queRegisterDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        this.queModifyDate=this.queRegisterDate;
    }

    @PreUpdate
    public void onPreUpdate(){
        this.queModifyDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
    }

    //문의 답변
    public void updateStateOn(){
        this.state = 1;
    }

    //문의 답변 삭제
    public void deleteState(){
        this.state = 0;
    }
}
