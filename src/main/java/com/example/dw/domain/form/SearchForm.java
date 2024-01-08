package com.example.dw.domain.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SearchForm {

    private String cate;
    private String keyword;


    public SearchForm(String cate, String keyword) {
        this.cate = cate;
        this.keyword = keyword;
    }

    public SearchForm(String keyword) {
        this.keyword = keyword;
    }

}
