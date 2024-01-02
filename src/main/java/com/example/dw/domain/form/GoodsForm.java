package com.example.dw.domain.form;

import com.example.dw.domain.entity.goods.Goods;
import com.example.dw.domain.entity.goods.GoodsCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GoodsForm {

    private Long id;
    @NotBlank(message = "필수 입력 사항입니다.")
    private String goodsName;
//    @Positive // 양수만 허용
    private Integer goodsQuantity;
//    @Positive // 양수만 허용
    private Integer goodsPrice;
//    @NotBlank(message = "필수 입력 사항입니다.")
    private String goodsMade;
//    @NotBlank(message = "필수 입력 사항입니다.")
    private String goodsCertify;
//    @NotBlank(message = "필수 입력 사항입니다.")
    private String goodsDetailContent;
//    @NotNull(message = "필수 입력 사항입니다.")
    private GoodsCategory goodsCategory;


    @Builder
    public GoodsForm(Long id, String goodsName, Integer goodsQuantity, Integer goodsPrice, String goodsMade,
                     String goodsCertify, String goodsDetailContent, GoodsCategory goodsCategory) {
        this.id = id;
        this.goodsName = goodsName;
        this.goodsQuantity = goodsQuantity;
        this.goodsPrice = goodsPrice;
        this.goodsMade = goodsMade;
        this.goodsCertify = goodsCertify;
        this.goodsDetailContent = goodsDetailContent;
        this.goodsCategory = goodsCategory;
    }

    public Goods toEntity(){
        return Goods.builder()
                .id(id)
                .goodsName(goodsName)
                .goodsPrice(goodsPrice)
                .goodsMade(goodsMade)
                .goodsQuantity(goodsQuantity)
                .goodsCertify(goodsCertify)
                .goodsCategory(goodsCategory)
                .goodsDetailContent(goodsDetailContent)
                .build();
    }


}
