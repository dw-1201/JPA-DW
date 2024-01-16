package com.example.dw.domain.form;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SearchReviewForm {

    private String cate;
    private String keyword;
    private String adminReplyState;

    public SearchReviewForm(String cate, String keyword, String adminReplyState) {
        this.cate = cate;
        this.keyword = keyword;
        this.adminReplyState = adminReplyState;
    }
}
