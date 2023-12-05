package com.example.dw.domain.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SearchFaqForm {

    private String cate;
    private String keyword;



}
