package com.example.dw.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchLocationForm {

    private String area;
    private String city;
    private String county;
    private String state;


    public SearchLocationForm(String area) {
        this.area = area;
    }

    public SearchLocationForm(String county, String state) {
        this.county = county;
        this.state = state;
    }
}
