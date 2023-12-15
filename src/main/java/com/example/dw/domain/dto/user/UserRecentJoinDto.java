package com.example.dw.domain.dto.user;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserRecentJoinDto {

    private Long id;
    private String userAccount;
    private String userName;
    private String userEmail;
    private String userPhone;
    private LocalDate userJoinDate;

    @QueryProjection
    public UserRecentJoinDto(Long id, String userAccount, String userName, String userEmail, String userPhone, LocalDate userJoinDate) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userJoinDate = userJoinDate;
    }
}
