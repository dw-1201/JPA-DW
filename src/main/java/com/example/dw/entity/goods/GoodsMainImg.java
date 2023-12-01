package com.example.dw.entity.goods;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="goods_main_img")
@Getter
@Setter
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

}
