package com.example.dw.domain.form;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminSearchOrderForm {


    private String cate;
    private String keyword;
    private String prev;
    private String next;

    public AdminSearchOrderForm(String cate, String keyword, String prev, String next) {
        this.cate = cate;
        this.keyword = keyword;
        this.prev = prev;
        this.next = next;
    }
}
