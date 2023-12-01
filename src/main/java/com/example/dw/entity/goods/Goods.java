package com.example.dw.entity.goods;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="goods")
@Getter
@Setter
public class Goods {
    @Id
    @GeneratedValue
    @Column(name="goods_id")
    private Long id;

    private String goodsName;
    private Long goodsQuantity;
    private Long goodsPrice;
    private String goodsMade;
    private String goodsCertify;
    private String goodsDetailContent;
    @Default
    private LocalDateTime goodsRegisterDate = LocalDateTime.now();
    @Default
    private LocalDateTime goodsModifyDate = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private GoodsCategory goodsCategory;

    @OneToOne(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private GoodsMainImg goodsMainImg;

    @OneToMany(mappedBy = "goods" ,fetch = FetchType.LAZY)
    private List<GoodsDetailImg> goodsDetailImg = new ArrayList<>();



}
