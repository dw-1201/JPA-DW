package com.example.dw.domain.dto.community;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MyFreeBoardResultListDto {

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
    private Long commentCount;

    private List<FreeBoardImgDto> freeBoardImgDtos;

    @QueryProjection

    public MyFreeBoardResultListDto(Long id, String freeBoardTitle, String freeBoardContent, Long userId, String userAccount, String userNickName, Long userFileId, String route, String name, String uuid, Long commentCount, List<FreeBoardImgDto> freeBoardImgDtos) {
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
        this.commentCount = commentCount;
        this.freeBoardImgDtos = freeBoardImgDtos;
    }
}
