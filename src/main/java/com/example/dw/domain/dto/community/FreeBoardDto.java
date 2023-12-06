package com.example.dw.domain.dto.community;

import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import com.example.dw.domain.entity.freeBoard.FreeBoardImg;
import com.example.dw.domain.entity.freeBoard.FreeBoardLike;
import com.example.dw.domain.entity.user.Users;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//freeBoardList 게시판 조회를 위한 DTO
@Data
@NoArgsConstructor
public class FreeBoardDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDate freeBoardRd;
    private LocalDate freeBoardMd;
    private Long freeBoardViewCount;

    private List<FreeBoardImg> freeBoardImg = new ArrayList<>();
    private List<FreeBoardComment> freeBoardComment = new ArrayList<>();
    private FreeBoardLike freeBoardLike;

    //유저 정보 추가
    private String userAccount;
    private Long userId;;
//    private Users users;

    @QueryProjection
    public FreeBoardDto(Long id, String freeBoardTitle, String freeBoardContent,
                        LocalDate freeBoardRd, LocalDate freeBoardMd, Long freeBoardViewCount,
                        List<FreeBoardImg> freeBoardImg, List<FreeBoardComment> freeBoardComment,
                        FreeBoardLike freeBoardLike, Users users) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.freeBoardImg = freeBoardImg;
        this.freeBoardComment = freeBoardComment;
        this.freeBoardLike = freeBoardLike;

        // 유저 정보 추가
        if (users != null) {
            // Hibernate.initialize를 사용하지 않고 바로 값을 가져오도록 변경
            this.userAccount = users.getUserAccount();
            this.userId = users.getId();
        }
//        this.userAccount = users.getUserAccount();
//        this.userId = users.getId();
    }
}
