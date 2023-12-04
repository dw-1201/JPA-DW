package com.example.dw.domain.entity.goods;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="goods_detail_img")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class GoodsDetailImg {
    @Id
    @GeneratedValue
    private Long id;


    private String goodsDetailImgName;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;

    @ManyToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Goods goods;


    @Builder
    public GoodsDetailImg(Long id, String goodsDetailImgName, String goodsDetailImgPath, String goodsDetailImgUuid, Goods goods) {
        this.id = id;
        this.goodsDetailImgName = goodsDetailImgName;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
        this.goods = goods;
    }

}
