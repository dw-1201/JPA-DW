package com.example.dw.domain.dto.admin;

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
    private Integer userState;

    private Long freeBoardCount;
    private Long qnaBoardCount;


    @QueryProjection
    public UserListDto(Long id, String userAccount, String userName, String userEmail,
                       String userPhone, Integer userState, Long freeBoardCount, Long qnaBoardCount) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userState = userState;
        this.freeBoardCount = freeBoardCount;
        this.qnaBoardCount = qnaBoardCount;
    }
}
