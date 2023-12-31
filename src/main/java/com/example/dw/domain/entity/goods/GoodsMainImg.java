package com.example.dw.domain.entity.goods;

import com.example.dw.domain.form.GoodsMainImgForm;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="goods_main_img")
@Getter
@ToString(exclude="goods")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsMainImg {
    @Id
    @GeneratedValue
    @Column(name = "goods_main_img_id")
    private Long id;
    private String goodsMainImgName;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goods_id")
    private Goods goods;


    @Builder
    public GoodsMainImg(Long id, String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid, Goods goods) {
        this.id = id;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goods = goods;
    }



    public GoodsMainImg(String goodsMainImgName, String goodsMainImgPath, String goodsMainImgUuid) {
        this.goodsMainImgName = goodsMainImgName;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
    }

    public GoodsMainImg updateMainImg(GoodsMainImgForm goodsMainImgForm){
        this.goodsMainImgName=goodsMainImgForm.getGoodsMainImgName();
        this.goodsMainImgPath=goodsMainImgForm.getGoodsMainImgPath();
        this.goodsMainImgUuid=goodsMainImgForm.getGoodsMainImgUuid();

        return this;
    }

}
