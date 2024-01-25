package com.example.dw.domain.dto.admin.goods;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class AdminGoodsReview {


    private Long goodsReviewId;
    private String goodsCategory;
    private String goodsName;
    private String goodsReviewContent;
    private Integer rating;
    private LocalDateTime goodsReviewRd;
    private Integer replyState;

    @QueryProjection
    public AdminGoodsReview(Long goodsReviewId, String goodsCategory, String goodsName, String goodsReviewContent, Integer rating, LocalDateTime goodsReviewRd, Integer replyState) {
        this.goodsReviewId = goodsReviewId;
        this.goodsCategory = goodsCategory;
        this.goodsName = goodsName;
        this.goodsReviewContent = goodsReviewContent;
        this.rating = rating;
        this.goodsReviewRd = goodsReviewRd;
        this.replyState = replyState;
    }

    //관리자 상품 상세 - 상품 관련 리뷰사항
    @Data
    public static class AdminGoodsRelatedReview{

        private Long goodsReviewId;
        private String goodsReviewContent;
        private Integer rating;
        private LocalDateTime goodsReviewRd;
        private Integer replyState;

        @QueryProjection
        public AdminGoodsRelatedReview(Long goodsReviewId, String goodsReviewContent, Integer rating, LocalDateTime goodsReviewRd, Integer replyState) {
            this.goodsReviewId = goodsReviewId;
            this.goodsReviewContent = goodsReviewContent;
            this.rating = rating;
            this.goodsReviewRd = goodsReviewRd;
            this.replyState = replyState;
        }
    }




    //상품 리뷰 리스트
    @Data
    public static class AdminGoodsReviewList {

        private String goodsCategory;
        private String goodsName;
        private String goodsReviewContent;
        private Integer rating;
        private LocalDateTime goodsReviewRd;
        private Integer replyState;


        public AdminGoodsReviewList(String goodsCategory, String goodsName, String goodsReviewContent, Integer rating, LocalDateTime goodsReviewRd, Integer replyState) {
            this.goodsCategory = goodsCategory;
            this.goodsName = goodsName;
            this.goodsReviewContent = goodsReviewContent;
            this.rating = rating;
            this.goodsReviewRd = goodsReviewRd;
            this.replyState = replyState;
        }

        @Data
        public static class AdminGoodsReviewResultList {
            private Long goodsReviewId;
            private AdminGoodsReviewList reviewList;


            public AdminGoodsReviewResultList(Long goodsReviewId, AdminGoodsReviewList reviewList) {
                this.goodsReviewId = goodsReviewId;
                this.reviewList = reviewList;
            }
        }
    }

    //상퓸 리뷰 상세보기
    @Data
    public static class AdminGoodsReviewDetail  {
        //리뷰 정보
        private Long orderReviewId;
        private String orderReviewContent;
        private String userAccount;
        private Integer rating;
        private LocalDateTime orderReviewRd;
        private Long orderReviewImgId;
        private String orderReviewImgPath;
        private String orderReviewImgUuid;
        private String orderReviewImgName;


        //리뷰 상품 정보
        private Long goodsId;
        private String goodsCategory;
        private String goodsName;
        private String goodsDetailContent;
        private double ratingAvg;

        private Long goodsMainImgId;
        private String goodsMainImgPath;
        private String goodsMainImgUuid;
        private String goodsMainImgName;


        @QueryProjection
        public AdminGoodsReviewDetail(String orderReviewContent, String userAccount, Integer rating, LocalDateTime orderReviewRd, Long orderReviewImgId, String orderReviewImgPath, String orderReviewImgUuid, String orderReviewImgName) {
            this.orderReviewContent = orderReviewContent;
            this.userAccount = userAccount;
            this.rating = rating;
            this.orderReviewRd = orderReviewRd;
            this.orderReviewImgId = orderReviewImgId;
            this.orderReviewImgPath = orderReviewImgPath;
            this.orderReviewImgUuid = orderReviewImgUuid;
            this.orderReviewImgName = orderReviewImgName;
        }

        @QueryProjection
        public AdminGoodsReviewDetail(Long goodsId, String goodsCategory, String goodsName, String goodsDetailContent, double ratingAvg, Long goodsMainImgId, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName) {
            this.goodsId = goodsId;
            this.goodsCategory = goodsCategory;
            this.goodsName = goodsName;
            this.goodsDetailContent = goodsDetailContent;
            this.ratingAvg = ratingAvg;
            this.goodsMainImgId = goodsMainImgId;
            this.goodsMainImgPath = goodsMainImgPath;
            this.goodsMainImgUuid = goodsMainImgUuid;
            this.goodsMainImgName = goodsMainImgName;
        }

        @Data
        public static class GoodsImg{
            private Long goodsMainImgId;
            private String goodsMainImgPath;
            private String goodsMainImgUuid;
            private String goodsMainImgName;

            public GoodsImg(Long goodsMainImgId, String goodsMainImgPath, String goodsMainImgUuid, String goodsMainImgName) {
                this.goodsMainImgId = goodsMainImgId;
                this.goodsMainImgPath = goodsMainImgPath;
                this.goodsMainImgUuid = goodsMainImgUuid;
                this.goodsMainImgName = goodsMainImgName;
            }
        }

        @Data
        public static class GoodsInfo{

            private Long goodsId;
            private String goodsCategory;
            private String goodsName;
            private String goodsDetailContent;
            private double ratingAvg;
            private GoodsImg goodsImg;

            public GoodsInfo(Long goodsId, String goodsCategory, String goodsName, String goodsDetailContent, double ratingAvg, GoodsImg goodsImg) {
                this.goodsId = goodsId;
                this.goodsCategory = goodsCategory;
                this.goodsName = goodsName;
                this.goodsDetailContent = goodsDetailContent;
                this.ratingAvg = ratingAvg;
                this.goodsImg = goodsImg;
            }
        }

        @Data
        public static class ReviewImg{
            private Long orderReviewImgId;
            private String orderReviewImgPath;
            private String orderReviewImgUuid;
            private String orderReviewImgName;

            public ReviewImg(Long orderReviewImgId, String orderReviewImgPath, String orderReviewImgUuid, String orderReviewImgName) {
                this.orderReviewImgId = orderReviewImgId;
                this.orderReviewImgPath = orderReviewImgPath;
                this.orderReviewImgUuid = orderReviewImgUuid;
                this.orderReviewImgName = orderReviewImgName;
            }
        }

        @Data
        public static class ReviewContent{

            private String orderReviewContent;
            private String userAccount;
            private Integer rating;
            private LocalDateTime orderReviewRd;
            private List<ReviewImg> reviewImg;

            public ReviewContent(String orderReviewContent, String userAccount, Integer rating, LocalDateTime orderReviewRd, List<ReviewImg> reviewImg) {
                this.orderReviewContent = orderReviewContent;
                this.userAccount = userAccount;
                this.rating = rating;
                this.orderReviewRd = orderReviewRd;
                this.reviewImg = reviewImg;
            }
        }

        @Data
        public static class AdminGoodsReviewResultDetail{
            private Long orderReviewId;
            private GoodsInfo goodsInfo;
            private ReviewContent reviewContent;

            public AdminGoodsReviewResultDetail(Long orderReviewId, GoodsInfo goodsInfo, ReviewContent reviewContent) {
                this.orderReviewId = orderReviewId;
                this.goodsInfo = goodsInfo;
                this.reviewContent = reviewContent;
            }
        }

    }
    
    //상품 관리자 답변 가져오기
    @Data
    public static class AdminGoodsReviewApply{

        private Long goodsReviewApplyId;
        private String goodsReviewReplyContent;
        private LocalDateTime goodsReviewReplyRd;
        private LocalDateTime goodsReviewReplyMd;

        @QueryProjection
        public AdminGoodsReviewApply(Long goodsReviewApplyId, String goodsReviewReplyContent, LocalDateTime goodsReviewReplyRd, LocalDateTime goodsReviewReplyMd) {
            this.goodsReviewApplyId = goodsReviewApplyId;
            this.goodsReviewReplyContent = goodsReviewReplyContent;
            this.goodsReviewReplyRd = goodsReviewReplyRd;
            this.goodsReviewReplyMd = goodsReviewReplyMd;
        }
    }


}

