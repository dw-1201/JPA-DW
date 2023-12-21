package com.example.dw.domain.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SearchLocationForm {


    private String city;
    private String county;
    private String state;

}
