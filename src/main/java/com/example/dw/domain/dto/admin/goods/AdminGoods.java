package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminGoods extends AdminGoodsStan {


    private Long goodsMainImgId;
    private String goodsMainImgPath;
    private String goodsMainImgUuid;
    private String goodsMainImgName;

    private Long goodsDetailImgId;
    private String goodsDetailImgPath;
    private String goodsDetailImgUuid;
    private String goodsDetailImgName;

    @QueryProjection
    public AdminGoods(Long goodsId, String goodsName, String goodsCategory, Integer goodsQuantity, Integer goodsPrice, Integer goodsSaleCount, String goodsDetailContent, String goodsMate, String goodsCertify, LocalDateTime goodsRd, LocalDateTime goodsMd, Long goodsMainImgId, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName, Long goodsDetailImgId, String goodsDetailImgPath, String goodsDetailImgUuid, String goodsDetailImgName) {
        super(goodsId, goodsName, goodsCategory, goodsQuantity, goodsPrice, goodsSaleCount, goodsDetailContent, goodsMate, goodsCertify, goodsRd, goodsMd);
        this.goodsMainImgId = goodsMainImgId;
        this.goodsMainImgPath = goodsMainImgPath;
        this.goodsMainImgUuid = goodsMainImgUuid;
        this.goodsMainImgName = goodsMainImgName;
        this.goodsDetailImgId = goodsDetailImgId;
        this.goodsDetailImgPath = goodsDetailImgPath;
        this.goodsDetailImgUuid = goodsDetailImgUuid;
        this.goodsDetailImgName = goodsDetailImgName;
    }

    //관리자 페이지 상품 리스트
    @Data
    public static class AdminGoodsList extends AdminGoodsStan {

        @QueryProjection
        public AdminGoodsList(Long goodsId, String goodsCategory, String goodsName, Integer goodsQuantity, Integer goodsSaleCount, Integer goodsPrice, LocalDateTime goodsRd, LocalDateTime goodsMd) {
            super(goodsId, goodsName, goodsCategory, goodsQuantity, goodsPrice, goodsSaleCount, goodsCategory, goodsRd, goodsMd);

        }
    }


    //관리자 페이지 상품 상세보기
    @Data
    public static class AdminGoodsDetail extends AdminGoodsStan{

        private Double ratingAvg;

        private String goodsMainImgPath;
        private String goodsMainImgUuid;
        private String goodsMainImgName;
        private List<AdminGoodsDetailImg> adminGoodsDetailImg;

        public AdminGoodsDetail(Long goodsId, String goodsName, String goodsCategory, Integer goodsQuantity, Integer goodsPrice, Integer goodsSaleCount, String goodsDetailContent, String goodsMate, String goodsCertify, LocalDateTime goodsRd, LocalDateTime goodsMd, Double ratingAvg, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName) {
            super(goodsId, goodsName, goodsCategory, goodsQuantity, goodsPrice, goodsSaleCount, goodsDetailContent, goodsMate, goodsCertify, goodsRd, goodsMd);

            this.ratingAvg = ratingAvg;
            this.goodsMainImgPath = goodsMainImgPath;
            this.goodsMainImgUuid = goodsMainImgUuid;
            this.goodsMainImgName = goodsMainImgName;
        }

        public AdminGoodsDetail setGoodsDetailImg(List<AdminGoodsDetailImg> adminGoodsDetailImg){
            this.adminGoodsDetailImg=adminGoodsDetailImg;
            return this;
       }

    }


}

