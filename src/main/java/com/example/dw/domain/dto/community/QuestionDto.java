package com.example.dw.domain.dto.community;


import com.example.dw.domain.entity.question.QuestionComment;
import com.example.dw.domain.entity.user.QUsers;
import com.example.dw.domain.entity.user.Users;
import com.querydsl.core.annotations.QueryProjection;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    private String questionTitle;
    private String questionContent;
    private LocalDateTime questionRd;
    private LocalDateTime questionMd;
    //조회수
//    private Long questionViewCount;

    private Users users;
    //댓글 수를 확인


    public QuestionDto(Long id, String questionTitle, String questionContent, LocalDateTime questionRd, LocalDateTime questionMd, Users users) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionRd = questionRd;
        this.questionMd = questionMd;
        this.users = users;

    }


}
