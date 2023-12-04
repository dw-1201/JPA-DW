package com.example.dw.domain.entity.goods;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods_category")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GoodsCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String goodsCategoryName;

    @OneToMany(mappedBy = "goodsCategory" ,fetch = FetchType.LAZY)
    private List<Goods> goods = new ArrayList<>();

    @Builder
    public GoodsCategory(Long id, String goodsCategoryName, List<Goods> goods) {
        this.id = id;
        this.goodsCategoryName = goodsCategoryName;
        this.goods = goods;
    }
}
