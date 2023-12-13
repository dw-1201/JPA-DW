package com.example.dw.domain.dto.user;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDetailDto {

    private Long id;
    private String userAccount;
    private String userName;
    private String userNickName;
    private String userPhone;
    private String userEmail;
    private String userJoinDate;
    private String zipCode;
    private String address;
    private String detail;
    private String intro;

    @QueryProjection
    public UserDetailDto(Long id, String userAccount, String userName, String userNickName, String userPhone, String userEmail, String userJoinDate, String zipCode, String address, String detail, String intro) {
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
