package com.example.dw.domain.dto.admin;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserListDto {


    private Long id;
    private String userAccount;
    private String userName;
    private String userEmail;
    private String userPhone;
    private LocalDate joinDate;
    private Integer userState;

    private Long questionBoardCount;
    private Long freeBoardCount;
    private Long walkBoardCount;




    @QueryProjection

    public UserListDto(Long id, String userAccount, String userName, String userEmail, String userPhone, LocalDate joinDate, Integer userState, Long questionBoardCount, Long freeBoardCount, Long walkBoardCount) {
        this.id = id;
        this.userAccount = userAccount;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.joinDate = joinDate;
        this.userState = userState;
        this.questionBoardCount = questionBoardCount;
        this.freeBoardCount = freeBoardCount;
        this.walkBoardCount = walkBoardCount;
    }
}
