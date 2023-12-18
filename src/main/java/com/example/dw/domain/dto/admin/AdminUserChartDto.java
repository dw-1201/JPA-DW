package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AdminUserChartDto {

    private LocalDate joinDate;
    private Long counts;

    @QueryProjection
    public AdminUserChartDto(LocalDate joinDate, Long counts) {
        this.joinDate = joinDate;
        this.counts = counts;
    }
}
