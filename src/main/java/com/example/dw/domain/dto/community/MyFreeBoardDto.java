package com.example.dw.domain.dto.community;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MyFreeBoardDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private Long userId;
    private String userAccount;
    private String userNickName;
    private Long userFileId;
    private String route;
    private String name;
    private String uuid;

    @QueryProjection
    public MyFreeBoardDto(Long id, String freeBoardTitle, String freeBoardContent, Long userId, String userAccount, String userNickName, Long userFileId, String route, String name, String uuid) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userNickName = userNickName;
        this.userFileId = userFileId;
        this.route = route;
        this.name = name;
        this.uuid = uuid;
    }
}
