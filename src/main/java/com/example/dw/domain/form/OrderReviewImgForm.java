package com.example.dw.domain.form;

import com.example.dw.domain.entity.order.OrderReview;
import com.example.dw.domain.entity.order.OrderReviewImg;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderReviewImgForm {

       private Long id;
       private String reviewimgFileName;
       private String reviewimgPath;
       private String reviewimgUuid;
       private OrderReview orderReview;

       @Builder
        public OrderReviewImgForm(Long id, String reviewimgFileName, String reviewimgPath, String reviewimgUuid, OrderReview orderReview) {
            this.id = id;
            this.reviewimgFileName = reviewimgFileName;
            this.reviewimgPath = reviewimgPath;
            this.reviewimgUuid = reviewimgUuid;
            this.orderReview = orderReview;
        }

        public OrderReviewImg toEntity(){
           return OrderReviewImg.builder()
                   .id(id)
                   .reviewimgFileName(reviewimgFileName)
                   .reviewimgPath(reviewimgPath)
                   .reviewimgUuid(reviewimgUuid)
                   .orderReview(orderReview)
                   .build();
        }
}
