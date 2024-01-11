package com.example.dw.domain.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SearchRecruitmentForm {

    private String state;

    public SearchRecruitmentForm(String state) {
        this.state = state;
    }
}
