package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminDto {


    private Long id;
    private String adminAccount;
    private String adminPassword;

    @QueryProjection
    public AdminDto(Long id, String adminAccount, String adminPassword) {
        this.id = id;
        this.adminAccount = adminAccount;
        this.adminPassword = adminPassword;
    }
}
