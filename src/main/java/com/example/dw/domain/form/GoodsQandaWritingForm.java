package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.goods.GoodsQue;
import com.example.dw.domain.entity.user.Users;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GoodsQandaWritingForm {

    private Long id;
    private String queContent;

    private Long goodsId;

    private Long userId;
    private String userAccount;

    public GoodsQue toEntity(){
        return GoodsQue.builder()
                .id(id)
                .queContent(queContent)
                .goods(Goods.builder().id(goodsId).build())
                .users(Users.builder().id(userId).build())
                .users(Users.builder().userAccount(userAccount).build())
                .build();
    }
    @Builder
    public GoodsQandaWritingForm(Long id, String queContent, Long goodsId, Long userId, String userAccount) {
        this.id = id;
        this.queContent = queContent;
        this.goodsId = goodsId;
        this.userId = userId;
        this.userAccount = userAccount;
    }
}
