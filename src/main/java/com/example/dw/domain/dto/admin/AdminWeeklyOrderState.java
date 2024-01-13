package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AdminWeeklyOrderState {


    private LocalDate saleDate;
    private Long saleCounts;

    @QueryProjection

    public AdminWeeklyOrderState(LocalDate saleDate, Long saleCounts) {
        this.saleDate = saleDate;
        this.saleCounts = saleCounts;
    }
}
