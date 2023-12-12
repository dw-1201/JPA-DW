package com.example.dw.domain.dto.user;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserListDto {


    private Long id;
    private String userAccount;
    private String userName;
    private String userEmail;
    private String userPhone;


    @QueryProjection
    public UserListDto(Long id, String userAccount, String userName, String userEmail, String userPhone) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
    }

}
