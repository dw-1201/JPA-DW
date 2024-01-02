package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.GoodsQue;
import com.example.dw.domain.entity.goods.GoodsQueReply;
import com.example.dw.domain.entity.user.Users;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsQueReplyForm {


    private Long id;
    private String qnaReplyContent;
    private Long goodsQueId;
    private Long userId;

    @Builder
    public GoodsQueReplyForm(Long id, String qnaReplyContent, Long goodsQueId, Long userId) {
        this.id = id;
        this.qnaReplyContent = qnaReplyContent;
        this.goodsQueId = goodsQueId;
        this.userId = userId;
    }


    public GoodsQueReply toEntity(){
        return GoodsQueReply.builder()
                .id(id)
                .queReplyContent(qnaReplyContent)
                .goodsQue(GoodsQue.builder().id(goodsQueId).build())
                .users(Users.builder().id(userId).build())
                .build();
    }
}
