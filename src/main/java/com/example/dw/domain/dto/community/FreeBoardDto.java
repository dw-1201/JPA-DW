package com.example.dw.domain.dto.community;

import com.example.dw.domain.entity.freeBoard.FreeBoardComment;
import com.example.dw.domain.entity.freeBoard.FreeBoardImg;
import com.example.dw.domain.entity.freeBoard.FreeBoardLike;
import com.example.dw.domain.entity.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class FreeBoardDto {

    private Long id;
    private String freeBoardTitle;
    private String freeBoardContent;
    private LocalDateTime freeBoardRd;
    private LocalDateTime freeBoardMd;
    private Long freeBoardViewCount;

    private List<FreeBoardImg> freeBoardImg = new ArrayList<>();
    private List<FreeBoardComment> freeBoardComment = new ArrayList<>();
    private FreeBoardLike freeBoardLike;

    public FreeBoardDto(Long id, String freeBoardTitle, String freeBoardContent, LocalDateTime freeBoardRd, LocalDateTime freeBoardMd, Long freeBoardViewCount, List<FreeBoardImg> freeBoardImg, List<FreeBoardComment> freeBoardComment, FreeBoardLike freeBoardLike, Users users) {
        this.id = id;
        this.freeBoardTitle = freeBoardTitle;
        this.freeBoardContent = freeBoardContent;
        this.freeBoardRd = freeBoardRd;
        this.freeBoardMd = freeBoardMd;
        this.freeBoardViewCount = freeBoardViewCount;
        this.freeBoardImg = freeBoardImg;
        this.freeBoardComment = freeBoardComment;
        this.freeBoardLike = freeBoardLike;
    }
}
