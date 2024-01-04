package com.example.dw.domain.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SearchCateLocationForm {

    private String cate;
    private String keyword;
    private String area;
    private String city;
    private String county;
    private String state;
    private String startDate;
    private String endDate;


    public SearchCateLocationForm(String cate, String keyword, String area, String city, String county, String state, String startDate, String endDate) {
        this.cate = cate;
        this.keyword = keyword;
        this.area = area;
        this.city = city;
        this.county = county;
        this.state = state;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
