package com.example.dw.entity.goods;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods_category")
@Getter
@Setter
public class GoodsCategory {
    @Id
    @GeneratedValue
    private Long id;
    private String goodsCategoryName;

    @OneToMany(mappedBy = "goodsCategory" ,fetch = FetchType.LAZY)
    private List<Goods> goods = new ArrayList<>();


}
