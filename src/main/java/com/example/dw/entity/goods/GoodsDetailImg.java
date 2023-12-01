package com.example.dw.entity.goods;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="goods_detail_img")
@Getter
@Setter
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
}
