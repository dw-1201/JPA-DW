package com.example.dw.domain.dto.admin;


import com.example.dw.domain.entity.user.UserFile;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDetailDto {

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
    private Long userFileId;
    private String route;
    private String name;
    private String uuid;

    @QueryProjection
    public UserDetailDto(Long id, String userAccount, String userName, String userNickName, String userPhone, String userEmail, LocalDate userJoinDate, String zipCode, String address, String detail, String intro, Long userFileId, String route, String name, String uuid) {
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
        this.userFileId = userFileId;
        this.route = route;
        this.name = name;
        this.uuid = uuid;
    }
}
