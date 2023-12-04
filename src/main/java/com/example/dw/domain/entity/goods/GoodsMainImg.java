package com.example.dw.domain.entity.goods;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="goods_main_img")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsMainImg {
    @Id
    @GeneratedValue
    private Long id;

    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;



    @OneToOne(fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    @JoinColumn(name = "goods_id")
    private Goods goods;

    @Builder
    public GoodsMainImg(Long id, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid, Goods goods) {
        this.id = id;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goods=goods;

    }


}
