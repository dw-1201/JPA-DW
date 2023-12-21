package com.example.dw.domain.dto.admin;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String userAccount;
    private String userName;
    private String userNickName;
    private String userPhone;
    private String userEmail;
    private LocalDate userJoinDate;
    private String zipCode;
    private String address;
    private String detail;
    private String intro;



    @QueryProjection
    public UserDto(Long id, String userAccount, String userName, String userNickName, String userPhone, String userEmail, LocalDate userJoinDate, String zipCode, String address, String detail, String intro) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userNickName = userNickName;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userJoinDate = userJoinDate;
        this.zipCode = zipCode;
        this.address = address;
        this.detail = detail;
        this.intro = intro;

    }
}
